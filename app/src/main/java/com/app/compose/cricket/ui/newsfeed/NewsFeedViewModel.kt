package com.app.compose.cricket.ui.newsfeed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.compose.cricket.domain.model.newsfeed.Article
import com.app.compose.cricket.usecase.GetCricketNewsFeedUseCase
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

    init {
        getNewsFeed()
    }

    private fun getNewsFeed() = viewModelScope.launch {
        val newsFeed = getCricketNewsFeedUseCase()
        _state.update {
            it.copy(
                articles = newsFeed.articles ?: listOf()
            )
        }
    }
}

data class NewsFeedState(
    val articles: List<Article> = listOf(),
    val article: Article? = null,
)