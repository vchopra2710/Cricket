package com.app.compose.cricket.ui.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch
import com.app.compose.cricket.usecase.GetCurrentMatchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val getCurrentMatchUseCase: GetCurrentMatchUseCase,
) : ViewModel() {

    private val _currentMatch = MutableStateFlow<CurrentMatch?>(null)
    val currentMatch: StateFlow<CurrentMatch?>
        get() = _currentMatch

    init {
        getCurrentMatches()
    }

    private fun getCurrentMatches() = viewModelScope.launch {
        val currentMatch = getCurrentMatchUseCase()
        _currentMatch.update { currentMatch }
    }
}