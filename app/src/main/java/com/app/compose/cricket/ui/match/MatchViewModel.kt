package com.app.compose.cricket.ui.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.compose.cricket.usecase.GetCurrentMatchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val getCurrentMatchUseCase: GetCurrentMatchUseCase,
) : ViewModel() {

    init {
        getCurrentMatches()
    }

    private fun getCurrentMatches() = viewModelScope.launch {
        getCurrentMatchUseCase()
    }
}