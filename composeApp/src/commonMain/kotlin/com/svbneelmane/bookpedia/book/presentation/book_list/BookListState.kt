package com.svbneelmane.bookpedia.book.presentation.book_list

import com.svbneelmane.bookpedia.book.domain.Book
import com.svbneelmane.bookpedia.core.presentation.UiText

/**
 * Data class that contains the Book List State
 * @created by shivaprasad-bhat on 21-Nov-2024
 */
data class BookListState(
    val searchQuery: String = "kotlin",
    val searchResults: List<Book> = booksMock,
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)

val booksMock = (1..50).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "https://test.com",
        authors = listOf("Shivaprasad"),
        description = "Description $it",
        languages = emptyList(),
        firstPublishedYear = null,
        averageRating = 4.78,
        ratingCount = 5,
        numPages = 20,
        numEditions = 3
    )
}
