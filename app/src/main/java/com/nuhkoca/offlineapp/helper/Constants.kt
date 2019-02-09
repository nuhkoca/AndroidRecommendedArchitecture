package com.nuhkoca.offlineapp.helper


/**
 * A helper class that holds appliation constants
 *
 * @author nuhkoca
 */
class Constants {
    init {
        throw AssertionError()
    }

    companion object {

        val DEFAULT_TIMEOUT = 60
        val EXECUTOR_THREAD_POOL_OFFSET = 5
        val DB_MIGRATION_START_VERSION = 1
        val DB_MIGRATION_TARGET_VERSION = 2
        val NEWS_DB_NAME = "news.db"
        val API_KEY = "apiKey"
    }
}
