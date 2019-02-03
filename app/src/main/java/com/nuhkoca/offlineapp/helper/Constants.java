package com.nuhkoca.offlineapp.helper;


/**
 * A helper class that holds appliation constants
 *
 * @author nuhkoca
 */
public final class Constants {

    public static final int DEFAULT_TIMEOUT = 60;
    public static final int EXECUTOR_THREAD_POOL_OFFSET = 5;
    public static final int INITIAL_LOAD_SIZE_HINT = 10;
    public static final int OFFSET_SIZE = 10;
    public static final int DB_MIGRATION_START_VERSION = 1;
    public static final int DB_MIGRATION_TARGET_VERSION = 2;
    public static final String NEWS_DB_NAME = "news.db";
    public static final String API_KEY = "apiKey";

    public Constants() {
        throw new AssertionError();
    }
}
