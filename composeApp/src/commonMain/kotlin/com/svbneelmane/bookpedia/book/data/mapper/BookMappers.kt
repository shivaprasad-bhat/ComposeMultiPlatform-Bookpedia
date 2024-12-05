package com.svbneelmane.bookpedia.book.data.mapper

import com.svbneelmane.bookpedia.book.data.dto.SearchedBookDto
import com.svbneelmane.bookpedia.book.domain.Book

fun SearchedBookDto.toBook(): Book {
    return Book(
        id = id,
        title = tittle,
        imageUrl = if (coverKey != null) "https://covers.openlibrary.org/b/olid/${coverKey}-L.jpg" else "https://covers.openlibrary.org/b/olid/${coverAlternativeKey}-L.jpg",
        authors = authorNames ?: emptyList(),
        description = null,
        languages = languages ?: emptyList(),
        firstPublishedYear = firstPublishYear.toString(),
        averageRating = ratingsAverage,
        ratingCount = ratingsCount,
        numEditions = numEditions ?: 0,
        numPages = numPagesMedian
    )
}