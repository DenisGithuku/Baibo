package com.githukudenis.baibo.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.githukudenis.baibo.presentation.screens.HomeViewModel
import com.ramcosta.composedestinations.annotation.Destination


@Destination(route = "home", start = true)
@Composable
fun Home(modifier: Modifier = Modifier) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val state = homeViewModel.uiState.collectAsState()
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.value.books?.let { books ->
            LazyColumn {
                items(books.The_New_Testament.split(' ')) {
                    Text(text = it)
                }
            }
        }
    }
}
