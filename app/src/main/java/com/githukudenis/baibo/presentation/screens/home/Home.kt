package com.githukudenis.baibo.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination


@OptIn(ExperimentalMaterialApi::class)
@Destination(route = "home", start = true)
@Composable
fun Home(modifier: Modifier = Modifier) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val state = homeViewModel.uiState.collectAsState()

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )

    BottomSheetScaffold(
        sheetShape = MaterialTheme.shapes.large.copy(
            topStart = CornerSize(16.dp),
            topEnd = CornerSize(16.dp),
        ), sheetContent = {
            if (!state.value.isLoadingBibles && state.value.userMessages.isEmpty() && state.value.bibles.isNotEmpty()) {
                LazyColumn {
                    items(state.value.bibles) {

                    }
                }
            }
        }, sheetPeekHeight = 0.dp
    ) {

    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(state.value.bibles) { bible ->
                Text(text = bible.title)
            }
        }
    }
}
