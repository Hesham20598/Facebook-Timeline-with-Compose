package com.example.facebooktimeline.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FacebookTimeLine() {

    Column(modifier = Modifier.fillMaxSize()) {
        FirstRow()
        SecondRow()
        ThirdRow()
        TimeLineContent()
    }
}

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun FacebookTimeLinePreview() {
    FacebookTimeLine()
}