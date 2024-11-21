package com.svbneelmane.bookpedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform