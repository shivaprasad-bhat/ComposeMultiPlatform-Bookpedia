package com.svbneelmane.bookpedia.book.presentation.book_list

import com.svbneelmane.bookpedia.book.domain.Book
import com.svbneelmane.bookpedia.core.presentation.UiText

/**
 * Data class that contains the Book List State
 * @created by shivaprasad-bhat on 21-Nov-2024
 */
data class BookListState(
    val searchQuery: String = "kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)


