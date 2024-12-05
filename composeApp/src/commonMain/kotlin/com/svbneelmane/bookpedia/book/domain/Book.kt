package com.svbneelmane.bookpedia.book.domain

/**
 * Data class that contains the details of each book
 * Data will be retrieved and parsed from API
 * @created by shivaprasad-bhat on 21-Nov-2024
 */
data class Book(
    val id: String,
    val title: String,
    val imageUrl: String,
    val authors: List<String>,
    val description: String?,
    val languages: List<String>,
    val firstPublishedYear: String?,
    val averageRating: Double?,
    val ratingCount: Int?,
    val numPages: Int?,
    val numEditions: Int
)
