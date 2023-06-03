package com.app.compose.cricket.ui.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.compose.cricket.usecase.GetSeriesDetailUseCase
import com.app.compose.cricket.usecase.GetSeriesListUseCase
import com.app.compose.cricket.utils.SingleEvent
import com.app.compose.cricket.utils.logDebug
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getSeriesListUseCase: GetSeriesListUseCase,
    private val getSeriesDetailUseCase: GetSeriesDetailUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(SeriesScreenState())
    val state: StateFlow<SeriesScreenState>
        get() = _state

    val showBottomSheet = SingleEvent()

    init {
        getSeries()
    }

    private fun getSeries() = viewModelScope.launch {
        val series = getSeriesListUseCase()
        _state.update { it.copy(series = series) }
    }

    fun getSeriesInfo(seriesId: String) = viewModelScope.launch {
        val seriesInfo = getSeriesDetailUseCase(seriesId = seriesId)
        _state.update { it.copy(seriesInfo = seriesInfo) }
        showBottomSheet.send()
    }
}