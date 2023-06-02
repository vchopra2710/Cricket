package com.app.compose.cricket.ui.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.compose.cricket.domain.model.series.Series
import com.app.compose.cricket.usecase.GetSeriesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getSeriesListUseCase: GetSeriesListUseCase,
) : ViewModel() {

    private val _series = MutableStateFlow<Series?>(null)
    val series: StateFlow<Series?>
        get() = _series

    init {
        getSeries()
    }

    private fun getSeries() = viewModelScope.launch {
        val series = getSeriesListUseCase()
        _series.update { series }
    }
}