package com.app.compose.cricket.ui.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private val _state = MutableStateFlow<MatchState>(MatchState())
    val state: StateFlow<MatchState>
        get() = _state

    init {
        getCurrentMatches()
    }

    private fun getCurrentMatches() = viewModelScope.launch {
        val currentMatch = getCurrentMatchUseCase()
        _state.update { it.copy(currentMatch = currentMatch) }
    }
}