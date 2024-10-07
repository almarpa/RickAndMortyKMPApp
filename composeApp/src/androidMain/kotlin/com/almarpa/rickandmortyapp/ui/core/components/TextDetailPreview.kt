package com.almarpa.rickandmortyapp.ui.core.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TextDetailPreview() {
    TextDetail(
        title = "Title",
        detail = "Detail"
    )
}