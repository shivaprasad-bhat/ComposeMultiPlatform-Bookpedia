package com.svbneelmane.bookpedia.book.domain

import com.svbneelmane.bookpedia.core.domain.DataError
import com.svbneelmane.bookpedia.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
}