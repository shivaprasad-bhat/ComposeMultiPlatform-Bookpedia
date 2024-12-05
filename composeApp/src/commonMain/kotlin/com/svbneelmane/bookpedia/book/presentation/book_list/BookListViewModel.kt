package com.svbneelmane.bookpedia.book.presentation.book_list

/**
 * ViewModel class for Book List Screen
 * @created by shivaprasad-bhat on 21-Nov-2024
 */
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svbneelmane.bookpedia.book.domain.Book
import com.svbneelmane.bookpedia.book.domain.BookRepository
import com.svbneelmane.bookpedia.core.domain.onError
import com.svbneelmane.bookpedia.core.domain.onSuccess
import com.svbneelmane.bookpedia.core.presentation.toUiText
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BookListViewModel(
    private val dataSource: BookRepository
) : ViewModel() {
    private val _state = MutableStateFlow(BookListState())
    val state = _state
        .onStart {
            if (cachedBookList.isEmpty()) {
                observeSearchQuery()
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    private var cachedBookList = emptyList<Book>()
    private var searchJob: Job? = null

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

    @OptIn(FlowPreview::class)
    private fun observeSearchQuery() {
        state.map {
            it.searchQuery
        }.distinctUntilChanged()
            .debounce(500L)
            .onEach { query ->
                when {
                    query.isBlank() -> {
                        _state.update {
                            it.copy(errorMessage = null, searchResults = cachedBookList)
                        }
                    }

                    query.length >= 2 -> {
                        searchJob?.cancel()
                        searchJob = searchBook(query)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun searchBook(query: String) = viewModelScope.launch {
        _state.update {
            it.copy(isLoading = true)
        }

        dataSource.searchBooks(query)
            .onSuccess { searchResult ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = null,
                        searchResults = searchResult
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        searchResults = emptyList(),
                        isLoading = false,
                        errorMessage = error.toUiText()
                    )
                }
            }
    }
}