package com.svbneelmane.bookpedia.book.presentation.book_list

/**
 * ViewModel class for Book List Screen
 * @created by shivaprasad-bhat on 21-Nov-2024
 */
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BookListViewModel : ViewModel() {
    private val _state = MutableStateFlow(BookListState())
    val state = _state.asStateFlow()


    fun onAction(action: BookListAction) {
        when (action) {
            is BookListAction.OnBookClicked -> {
                // To be implemented later
            }

            is BookListAction.OnSearchQueryChange -> {
                _state.update {
                    it.copy(
                        searchQuery = action.query
                    )
                }
            }

            is BookListAction.OnTabSelected -> {
                _state.update {
                    it.copy(
                        selectedTabIndex = action.index
                    )
                }
            }
        }
    }
}