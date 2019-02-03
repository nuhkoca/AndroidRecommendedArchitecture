package com.nuhkoca.offlineapp.repository;

import android.util.Log;

import java.util.concurrent.Callable;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public abstract class NetworkBoundResource<ResultType, RequestType> {
    private final MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();
    private Disposable mDisposable;

    @MainThread
    NetworkBoundResource() {
        result.setValue(Resource.loading(null));
        LiveData<ResultType> dbSource = loadFromDb();
        result.addSource(dbSource, data -> {
            result.removeSource(dbSource);
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource);
                Log.d("TAG", "Network called");
            } else {
                result.addSource(dbSource, newData -> result.setValue(Resource.success(newData)));
                Log.d("TAG", "DB called");
            }
        });
    }

    private void fetchFromNetwork(final LiveData<ResultType> dbSource) {
        result.addSource(dbSource, newData -> result.setValue(Resource.loading(newData)));
        createCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<RequestType>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (!d.isDisposed()) {
                            mDisposable = d;
                        }
                    }

                    @Override
                    public void onSuccess(RequestType requestType) {
                        result.removeSource(dbSource);
                        saveResultAndReInit(requestType);
                        Log.d("TAG", "Network called success");
                    }

                    @Override
                    public void onError(Throwable e) {
                        onFetchFailed();
                        result.removeSource(dbSource);
                        result.addSource(dbSource, newData -> result.setValue(Resource.error(e.getMessage(), newData)));
                        mDisposable.dispose();
                        Log.d("TAG", "Network called error");
                    }
                });
    }

    @MainThread
    private void saveResultAndReInit(RequestType response) {
        Completable
                .fromCallable((Callable<Void>) () -> {
                    saveCallResult(response);
                    return null;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (!d.isDisposed()) {
                            mDisposable = d;
                        }
                    }

                    @Override
                    public void onComplete() {
                        result.addSource(loadFromDb(), newData -> result.setValue(Resource.success(newData)));
                        mDisposable.dispose();
                        Log.d("TAG", "Network called reinit");
                    }

                    @Override
                    public void onError(Throwable e) {
                        mDisposable.dispose();
                        Log.d("TAG", "Network called error reinit");
                    }
                });
    }

    @WorkerThread
    protected abstract void saveCallResult(@NonNull RequestType item);

    @MainThread
    protected abstract boolean shouldFetch(@Nullable ResultType data);

    @NonNull
    @MainThread
    protected abstract LiveData<ResultType> loadFromDb();

    @NonNull
    @MainThread
    protected abstract Single<RequestType> createCall();

    @MainThread
    protected abstract void onFetchFailed();

    final LiveData<Resource<ResultType>> getAsLiveData() {
        return result;
    }
}
