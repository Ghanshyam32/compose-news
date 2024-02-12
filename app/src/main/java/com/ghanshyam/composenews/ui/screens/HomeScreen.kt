package com.ghanshyam.composenews.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ghanshyam.composenews.ui.component.Loader
import com.ghanshyam.composenews.ui.component.NewsList
import com.ghanshyam.composenews.ui.viewmodel.NewsViewModel
import com.ghanshyam.utilities.ResourceState

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsResponse by newsViewModel._news.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    )
    {
        when (newsResponse) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = (newsResponse as ResourceState.Success).data
                Log.d(TAG, "Inside Success ${response.status} = ${response.totalResults}")
                NewsList(response)
            }

            is ResourceState.Error -> {
                val error = newsResponse as ResourceState.Error
                Log.d(TAG, "Inside Error $error")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {

}