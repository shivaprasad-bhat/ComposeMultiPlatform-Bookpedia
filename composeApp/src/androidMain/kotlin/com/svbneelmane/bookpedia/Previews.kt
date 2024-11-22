package com.svbneelmane.bookpedia

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.svbneelmane.bookpedia.book.presentation.book_list.components.BookSearchBar

@Preview(showBackground = true)
@PreviewLightDark
@Composable
fun BookPreview(modifier: Modifier = Modifier) {
    MaterialTheme {
        BookSearchBar(
            searchQuery = "Kotlin",
            onSearchQueryChange = { },
            onImeSearch = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}