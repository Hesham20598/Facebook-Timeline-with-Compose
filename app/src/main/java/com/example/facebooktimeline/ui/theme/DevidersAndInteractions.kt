package com.example.facebooktimeline.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InteractImage(id: Int, description: String) {

    Image(
        painter = painterResource(id = id),
        contentDescription = description,
        modifier = Modifier.size(20.dp)
    )

}

@Composable
fun SecondDevider() {
    Row(
        Modifier
            .padding(vertical = 8.dp)
            .height(8.dp)
            .background(color = SecondDeviderColor)
            .fillMaxWidth()) {}
}

@Preview(showSystemUi = true , showBackground = true)
@Composable
fun Preview() {
    SecondDevider()
}