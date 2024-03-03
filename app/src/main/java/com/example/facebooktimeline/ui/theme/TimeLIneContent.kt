package com.example.facebooktimeline.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebooktimeline.R
import com.example.facebooktimeline.model.Post
import com.example.facebooktimeline.model.Story

val postsList = mutableListOf<Post>()
val storyList = mutableListOf<Story>()

@Composable
fun TimeLineContent() {

    for (i in 0..3) {
        postsList.add(
            Post(
                "Mark Lee",
                R.drawable.unknown,
                "9:00 pm",
                "Hi there my name is Mark Lee and I am a singer",
                R.drawable.sea_pic,
                12,
                100,
                1000
            )
        )
        postsList.add(
            Post(
                "Hesham Ghanem",
                R.drawable.me1,
                "9:00 pm",
                "Hi there my name is Mark Lee and I am a singer",
                R.drawable.aqsa,
                12,
                100,
                1000
            )
        )

        storyList.add(Story("Mark Lee", R.drawable.unknown, R.drawable.sea_pic))
        storyList.add(Story("Hesham Ghanem", R.drawable.me1, R.drawable.aqsa))
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()

    ) {
        item {
            ThirdRow()
        }
        item { SecondDevider() }
        item {
            LazyRow(
                modifier = Modifier
                    .padding(start = 10.dp)
            ) {
                items(storyList.size) { position ->
                    StoryUI(storyList.get(position))
                }
            }
        }

        item { SecondDevider() }
        PostsList()
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TimeLineContentPreview() {
    TimeLineContent()
}


fun LazyListScope.PostsList() {
    items(postsList.size) { position ->
        PostUI(postsList.get(position))
    }
}