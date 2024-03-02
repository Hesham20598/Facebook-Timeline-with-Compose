package com.example.facebooktimeline.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebooktimeline.R
import com.example.facebooktimeline.model.Post
import com.example.facebooktimeline.model.Story

@Composable
fun TimeLineContent() {
//    val state = rememberScrollState()
    val postsList = mutableListOf<Post>()
    val storyList = mutableListOf<Story>()
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
        storyList.add(Story("Mark Lee", R.drawable.unknown, R.drawable.sea_pic))
    }




    Column(
        modifier = Modifier
            .fillMaxSize()
//            .verticalScroll(state)


    ) {
        SecondDevider()
        LazyRow(
            modifier = Modifier
                .padding(start = 10.dp)
        ) {
            items(storyList.size) { position ->
                StoryUi(storyList.get(position))
            }
        }

        SecondDevider()
        LazyColumn() {
            items(postsList.size) { position ->
                Post(postsList.get(position))
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TimeLineContentPreview() {
    TimeLineContent()
}
