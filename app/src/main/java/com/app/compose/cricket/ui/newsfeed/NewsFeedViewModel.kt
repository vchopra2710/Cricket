package com.app.compose.cricket.ui.newsfeed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.compose.cricket.usecase.GetCricketNewsFeedUseCase
import com.app.compose.cricket.utils.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    private val getCricketNewsFeedUseCase: GetCricketNewsFeedUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(NewsFeedState())
    val state: StateFlow<NewsFeedState>
        get() = _state

    val showBottomSheet = SingleEvent()

    fun getNewsFeed(searchQuery: String) = viewModelScope.launch {
        val newsFeed = getCricketNewsFeedUseCase(
            query = searchQuery
        )
        _state.update {
            it.copy(
                articles = newsFeed.articles ?: listOf()
            )
        }.also {
            showBottomSheet.send()
        }
    }
}