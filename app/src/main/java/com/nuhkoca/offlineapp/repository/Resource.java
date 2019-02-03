package com.nuhkoca.offlineapp.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.nuhkoca.offlineapp.repository.Status.ERROR;
import static com.nuhkoca.offlineapp.repository.Status.LOADING;
import static com.nuhkoca.offlineapp.repository.Status.SUCCESS;

public class Resource<T> {
    @NonNull
    public final Status status;
    @Nullable
    public final T data;
    @Nullable public final String message;
    private Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(ERROR, data, msg);
    }

    static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }
}
