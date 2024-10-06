package com.almarpa.rickandmortyapp.ui.core.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.almarpa.rickandmortyapp.ui.theme.DefaultTextColor
import com.almarpa.rickandmortyapp.ui.theme.Green

@Composable
fun InformationDetail(title: String, detail: String) {
    Row {
        Text(title, color = DefaultTextColor, fontWeight = FontWeight.Bold)
        Spacer(Modifier.width(4.dp))
        Text(detail, color = Green)
    }
}