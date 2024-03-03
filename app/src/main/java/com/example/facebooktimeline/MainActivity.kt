package com.example.facebooktimeline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.facebooktimeline.ui.theme.FacebookTimeLine
import com.example.facebooktimeline.ui.theme.FacebookTimeLineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FacebookTimeLineTheme {
                FacebookTimeLine()
            }
        }
    }
}















