package com.example.facebooktimeline.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.facebooktimeline.R
import com.example.facebooktimeline.model.Story

@Composable
fun StoryUi(story: Story) {
    Card(
        modifier = Modifier
            .padding(end = 10.dp)
            .width(110.dp)
            .height(210.dp)
            .clip(shape = RoundedCornerShape(20.dp))
    ) {
        ConstraintLayout {
            val (storyImage, userImage, userName) = createRefs()
            Image(
                painter = painterResource(id = story.storyImage ?: 0),
                contentDescription = "Story Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.constrainAs(storyImage) {
                }
            )

            Image(
                painterResource(id = story.userImage ?: 0),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .constrainAs(userImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .padding(8.dp)
                    .size(40.dp)
                    .border(width = 3.dp, color = FacebookBlue, shape = CircleShape)
                    .padding(6.dp)
                    .clip(shape = CircleShape)

            )

            Text(
                text = story.userName ?: "",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,

                    ),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .constrainAs(userName) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    })

        }


    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun StoryPreview() {
    StoryUi(story = Story("Mark Lee", R.drawable.unknown, R.drawable.sea_pic))
}