package com.svbneelmane.bookpedia.book.presentation.book_details

import com.svbneelmane.bookpedia.book.domain.Book

data class BookDetailsState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)