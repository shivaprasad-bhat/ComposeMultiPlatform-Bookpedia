package com.svbneelmane.bookpedia.core.domain

sealed interface DataError : Error {
    enum class Remote : DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUEST,
        NO_INTERNET,
        SERVER_ERROR,
        SERIALIZATION_ERROR,
        UNKNOWN_ERROR
    }

    enum class Local : DataError {
        DISK_FULL_ERROR,
        UNKNOWN_ERROR
    }
}