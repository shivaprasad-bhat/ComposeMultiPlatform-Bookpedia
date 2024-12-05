package com.svbneelmane.bookpedia

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.svbneelmane.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.svbneelmane.bookpedia.book.data.repository.DefaultBookRepository
import com.svbneelmane.bookpedia.book.presentation.book_list.BookListScreenRoot
import com.svbneelmane.bookpedia.book.presentation.book_list.BookListViewModel
import com.svbneelmane.bookpedia.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember {
            BookListViewModel(
                dataSource = DefaultBookRepository(
                    remoteBookDataSource = KtorRemoteBookDataSource(
                        httpClient = HttpClientFactory.create(
                            engine
                        )
                    )
                )
            )
        },
        onBookClick = {

        }
    )
}