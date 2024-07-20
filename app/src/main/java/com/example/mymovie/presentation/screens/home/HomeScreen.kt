package com.example.mymovie.presentation.screens.home

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mymovie.R
import com.example.mymovie.presentation.components.SearchBar
import com.example.mymovie.presentation.screens.home.components.CategoryCollection
import com.example.mymovie.presentation.screens.home.components.NowPlayingList
import com.example.mymovie.presentation.screens.home.components.PopularList
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreen(
    toDetail: (Int) -> Unit,
    toSearch: () -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    viewModel: HomeViewModel = koinViewModel()
) {
    val popularState by viewModel.popularState.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(
                text = stringResource(R.string.home_title),
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                modifier = Modifier.padding(24.dp)
            )
        }
        item {
            Surface(onClick = toSearch) {
                SearchBar(modifier = Modifier.padding(horizontal = 24.dp), enabled = false)
            }
        }
        item {
            PopularList(
                onItemClick = toDetail,
                sharedTransitionScope,
                animatedContentScope,
                state = popularState
            )
        }
        CategoryCollection(modifier = Modifier.padding(top = 32.dp), title = "Upcoming")
        item {
            NowPlayingList(modifier = Modifier.padding(top = 8.dp))
        }
        CategoryCollection(modifier = Modifier.padding(top = 24.dp), title = "Top Rated")
    }
}