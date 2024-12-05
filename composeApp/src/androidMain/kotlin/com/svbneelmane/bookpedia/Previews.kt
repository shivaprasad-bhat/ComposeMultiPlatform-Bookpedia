package com.svbneelmane.bookpedia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.svbneelmane.bookpedia.book.domain.Book
import com.svbneelmane.bookpedia.book.presentation.book_list.BookListScreen
import com.svbneelmane.bookpedia.book.presentation.book_list.BookListState
import com.svbneelmane.bookpedia.book.presentation.book_list.components.BookSearchBar

//@Preview
//@PreviewLightDark
@Composable
private fun BookPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(20.dp)
    ) {
        BookSearchBar(
            searchQuery = "Kotlin",
            onSearchQueryChange = { },
            onImeSearch = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview
@Composable
private fun BookListScreenPreview() {
    BookListScreen(
        state = BookListState(
            searchResults = booksMock,
        ),
        onAction = {}
    )

}

private val booksMock = (1..50).map {
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