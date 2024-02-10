package com.ghanshyam.composenews.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ghanshyam.composenews.ui.viewmodel.NewsViewModel

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    )
    {

    }
}

@Preview
@Composable
fun HomeScreenPreview(){

}