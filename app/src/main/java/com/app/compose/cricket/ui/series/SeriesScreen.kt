package com.app.compose.cricket.ui.series

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SeriesScreen(
    viewModel: SeriesViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.state.collectAsState()
    val scaffoldState = rememberBottomSheetScaffoldState()

    viewModel.showBottomSheet.collect {
        scope.launch { scaffoldState.bottomSheetState.expand() }
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            SeriesInfoLayout(
                seriesDetail = state.seriesInfo?.data,
            )
        },
        sheetPeekHeight = 0.dp,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding(),
    ) { paddingValues ->
        SeriesList(
            seriesDataList = state.series?.seriesData ?: listOf(),
            getSeriesInfo = viewModel::getSeriesInfo,
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.Black),
        )
    }
}