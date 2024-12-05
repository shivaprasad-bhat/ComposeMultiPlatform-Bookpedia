package com.svbneelmane.bookpedia.core.presentation

import cmp_bookpedia.composeapp.generated.resources.Res
import cmp_bookpedia.composeapp.generated.resources.disk_full_error
import cmp_bookpedia.composeapp.generated.resources.no_internet_error
import cmp_bookpedia.composeapp.generated.resources.request_timeout_error
import cmp_bookpedia.composeapp.generated.resources.serialization_error
import cmp_bookpedia.composeapp.generated.resources.too_many_requests_error
import cmp_bookpedia.composeapp.generated.resources.unknown_error
import com.svbneelmane.bookpedia.core.domain.DataError

fun DataError.toUiText(): UiText {
    val strRes = when (this) {
        DataError.Local.DISK_FULL_ERROR -> Res.string.disk_full_error
        DataError.Local.UNKNOWN_ERROR -> Res.string.unknown_error
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.request_timeout_error
        DataError.Remote.TOO_MANY_REQUEST -> Res.string.too_many_requests_error
        DataError.Remote.NO_INTERNET -> Res.string.no_internet_error
        DataError.Remote.SERVER_ERROR -> Res.string.unknown_error
        DataError.Remote.SERIALIZATION_ERROR -> Res.string.serialization_error
        DataError.Remote.UNKNOWN_ERROR -> Res.string.unknown_error
    }

    return UiText.StringResourceId(strRes)
}