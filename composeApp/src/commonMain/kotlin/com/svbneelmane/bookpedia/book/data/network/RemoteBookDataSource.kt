package com.svbneelmane.bookpedia.book.data.network

import com.svbneelmane.bookpedia.book.data.dto.SearchResponseDto
import com.svbneelmane.bookpedia.core.domain.DataError
import com.svbneelmane.bookpedia.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>
}