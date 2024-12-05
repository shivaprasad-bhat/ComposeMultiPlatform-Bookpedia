package com.svbneelmane.bookpedia.book.data.repository

import com.svbneelmane.bookpedia.book.data.mapper.toBook
import com.svbneelmane.bookpedia.book.data.network.RemoteBookDataSource
import com.svbneelmane.bookpedia.book.domain.Book
import com.svbneelmane.bookpedia.book.domain.BookRepository
import com.svbneelmane.bookpedia.core.domain.DataError
import com.svbneelmane.bookpedia.core.domain.Result
import com.svbneelmane.bookpedia.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) : BookRepository {
    override suspend fun searchBooks(
        query: String
    ): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query).map { dto ->
            dto.results.map { it.toBook() }
        }
    }
}