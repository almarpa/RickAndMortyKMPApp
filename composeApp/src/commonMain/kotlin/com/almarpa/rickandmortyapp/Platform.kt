package com.almarpa.rickandmortyapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform