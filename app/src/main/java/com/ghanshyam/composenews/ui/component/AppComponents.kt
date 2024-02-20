package com.ghanshyam.composenews.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ghanshyam.composenews.R
import com.ghanshyam.composenews.dataLayer.entity.Article
import com.ghanshyam.composenews.dataLayer.entity.NewsResponse


@Composable
fun Loader() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp), color = Color.Black
        )
    }
}

@Composable
fun NewsList(response: NewsResponse) {
    LazyColumn() {
        items(response.articles) { article ->
            NormalText(textValue = article.title ?: "NOT AVAILABLE")
        }
    }
}

@Composable
fun NormalText(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 18.sp, fontWeight = FontWeight.Normal
        )
    )

}

@Composable
fun HeadingText(textValue: String, centerAligned: Boolean) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 24.sp, fontWeight = FontWeight.Medium
        ),
        textAlign = if (centerAligned) TextAlign.Center else TextAlign.Start
    )
}

@Composable
fun NewsRowComponent(page: Int, article: Article) {
//    NormalText(textValue = "$page \n\n ${article.title}")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article.urlToImage,
            contentDescription = "",
            contentScale = ContentScale.Fit,
            placeholder = painterResource(id = R.drawable.placeholder_image),
            error = painterResource(id = R.drawable.placeholder_image)
        )

        Spacer(modifier = Modifier.size(20.dp))
        HeadingText(textValue = article.title ?: "", centerAligned = false)

        Spacer(modifier = Modifier.size(10.dp))
        NormalText(textValue = article.description ?: "")

        Spacer(modifier = Modifier.weight(1f))
        AuthorDetails(article.author, article.source?.name)

    }
}

@Preview
@Composable
fun NewsRowComponentPreview() {
    val article = Article(
        author = "", title = "", null, null, null, null, null, null
    )
    NewsRowComponent(page = 0, article)
}

@Composable
fun AuthorDetails(authorName: String?, authorSource: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 24.dp)
    ) {

        authorName?.also {
            Text(text = it, color = Color.Gray)
        }

        Spacer(modifier = Modifier.weight(1f))


        authorSource?.also {
            Text(text = it, color = Color.Gray)
        }

    }
}

@Composable
fun EmptyState() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.no_connection), contentDescription = "No News"
        )

        HeadingText(textValue = "\" Ran into some error", centerAligned = true)

    }
}

@Preview
@Composable
fun EmptyStatePreview() {
    EmptyState()
}