package com.almarpa.rickandmortyapp

import androidx.compose.ui.window.ComposeUIViewController
import com.almarpa.rickandmortyapp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }