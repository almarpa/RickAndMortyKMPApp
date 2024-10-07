package com.almarpa.rickandmortyapp.ui.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.almarpa.rickandmortyapp.ui.theme.BackgroundPrimaryColor
import org.jetbrains.compose.resources.painterResource
import rickandmortyapp.composeapp.generated.resources.Res
import rickandmortyapp.composeapp.generated.resources.ricktoolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(scrollBehaviour: TopAppBarScrollBehavior) {
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(Res.drawable.ricktoolbar),
                contentDescription = null,
                modifier = Modifier.padding(vertical = 32.dp)
            )
        },
        navigationIcon = {},
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = BackgroundPrimaryColor,
        ),
        scrollBehavior = scrollBehaviour,
    )
}