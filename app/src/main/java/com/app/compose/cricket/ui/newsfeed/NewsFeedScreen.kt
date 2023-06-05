package com.app.compose.cricket.ui.newsfeed

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.compose.cricket.domain.model.Countries
import com.app.compose.cricket.domain.model.newsfeed.Article
import com.app.compose.cricket.ui.compose.AsyncImage
import com.app.compose.cricket.ui.compose.Text
import com.app.compose.cricket.utils.bitmapDescriptor
import com.app.compose.cricket.utils.fromHtml
import com.app.compose.cricket.utils.openBrowser
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewsFeedScreen(
    viewModel: NewsFeedViewModel = hiltViewModel()
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .statusBarsPadding(),
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val scaffoldState = rememberBottomSheetScaffoldState()

    val state by viewModel.state.collectAsState()
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(state.zoomedCountry.latLng, 10f)
    }
    val uiSettings by remember { mutableStateOf(MapUiSettings()) }
    val properties by remember {
        mutableStateOf(
            MapProperties(
                mapType = MapType.SATELLITE,
                maxZoomPreference = 3f
            )
        )
    }
    viewModel.showBottomSheet.collect {
        scope.launch { scaffoldState.bottomSheetState.expand() }
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            NewsFeedList(
                articles = state.articles,
                modifier = Modifier.background(Color.Black),
                onClick = { article -> context.openBrowser(url = article.url ?: "") }
            )
        },
        sheetPeekHeight = 0.dp,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding(),
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = properties,
            uiSettings = uiSettings,
        ) {
            Countries.values().toList().forEach {
                Marker(
                    state = MarkerState(position = it.latLng),
                    title = it.name,
                    icon = context.bitmapDescriptor(id = it.icon),
                    onInfoWindowClick = { _ -> viewModel.getNewsFeed(it.searchQuery) },
                )
            }

        }
    }


}

@Composable
private fun NewsFeedList(
    articles: List<Article>,
    modifier: Modifier = Modifier,
    onClick: (Article) -> Unit,
) = LazyColumn(
    modifier = modifier
        .fillMaxSize()
        .then(Modifier.padding(8.dp)),
) {
    items(articles.count()) {
        NewsFeedItem(
            article = articles[it],
            onClick = onClick,
        )
    }
}

@Composable
private fun NewsFeedItem(
    article: Article,
    onClick: (Article) -> Unit,
) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(Color.Gray.copy(alpha = 0.5f))
        .then(Modifier.padding(8.dp))
        .clickable { onClick(article) }
) {
    AsyncImage(
        url = article.urlToImage ?: "",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = article.title ?: "",
        maxLines = 2,
        fontWeight = FontWeight.Bold,
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = fromHtml(article.description ?: "").toString(),
        maxLines = Int.MAX_VALUE,
        fontWeight = FontWeight.Normal,
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "${article.author} | ${article.publishedAt}",
        maxLines = 1,
        fontWeight = FontWeight.Normal,
    )
}