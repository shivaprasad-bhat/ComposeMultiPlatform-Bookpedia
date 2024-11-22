package com.svbneelmane.bookpedia.book.presentation.book_list

import com.svbneelmane.bookpedia.book.domain.Book

/**
 * Sealed Interface contains different actions that can be taken on book list
 * @created by shivaprasad-bhat on 21-Nov-2024
 */
sealed interface BookListAction {
    data class OnSearchQueryChange(val query: String) : BookListAction
    data class OnBookClicked(val book: Book) : BookListAction
    data class OnTabSelected(val index: Int) : BookListAction
}
