package com.example.facebooktimeline.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.facebooktimeline.R

@Composable
fun FirstRow() {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.facebook),
            style = TextStyle(
                color = FacebookBlue,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            ), modifier = Modifier.padding(start = 20.dp)
        )
        Row(
            modifier = Modifier
                .padding(end = 16.dp)
                .fillMaxWidth(.6f), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_messenger),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}

@Composable
fun SecondRow() {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
    ) {
        ConstraintLayout() {
            val (ic_home, ic_reels, ic_friends, ic_market, ic_notification, userImage, ic_menu, deviderLine) = createRefs()
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(ic_home) {
                start.linkTo(parent.start)
                end.linkTo(ic_reels.start)
                top.linkTo(parent.top)
            }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(35.dp)
                )
            }

            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(ic_reels) {
                start.linkTo(ic_home.end)
                end.linkTo(ic_friends.start)
                top.linkTo(parent.top)
            }) {

                Image(
                    painter = painterResource(id = R.drawable.ic_reels),
                    contentDescription = "Reels",
                    modifier = Modifier.size(35.dp)
                )
            }

            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(ic_friends) {
                start.linkTo(ic_reels.end)
                end.linkTo(ic_market.start)
                top.linkTo(parent.top)
            }) {

                Image(
                    painter = painterResource(id = R.drawable.ic_friends),
                    contentDescription = "Friends",
                    modifier = Modifier.size(35.dp)
                )
            }

            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(ic_market) {
                start.linkTo(ic_friends.end)
                end.linkTo(ic_notification.start)
                top.linkTo(parent.top)
            }) {

                Image(
                    painter = painterResource(id = R.drawable.ic_shop),
                    contentDescription = "Market",
                    modifier = Modifier.size(35.dp)
                )
            }

            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(ic_notification) {
                start.linkTo(ic_market.end)
                end.linkTo(userImage.start)
                top.linkTo(parent.top)
            }) {

                Image(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "Notification",
                    modifier = Modifier.size(35.dp)
                )
            }


            Image(
                painter = painterResource(id = R.drawable.unknown),
                contentDescription = "User Image",
                modifier = Modifier
                    .size(40.dp)
                    .border(width = 3.dp, color = Color.Gray, shape = CircleShape)
                    .clip(CircleShape)
                    .constrainAs(userImage) {
                        start.linkTo(ic_notification.end)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    })

            Image(painter = painterResource(id = R.drawable.ic_menue),
                contentDescription = "Notification",
                modifier = Modifier
                    .padding(top = 28.dp, end = 16.dp)
                    .size(20.dp)
                    .border(width = 2.dp, color = Color.White, shape = CircleShape)
                    .constrainAs(ic_menu) {
                        bottom.linkTo(userImage.bottom)
                        end.linkTo(userImage.end)
                        top.linkTo(userImage.top)
                        start.linkTo(userImage.end)
                    })

            Row(modifier = Modifier
                .padding(top = 1.dp)
                .height(1.dp)
                .fillMaxWidth()
                .background(color = DeviderColor)
                .constrainAs(deviderLine) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(ic_home.bottom)
                }) {}


        }
    }
}


@Composable
fun ThirdRow() {
    val textState = remember {
        mutableStateOf("What's in your mind?")
    }
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.unknown),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )


        Text(
            text = stringResource(R.string.what_s_in_your_mind), style = TextStyle(
                fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth(.8f)
                .border(
                    2.dp,
                    color = DeviderColor,
                    shape = RoundedCornerShape(25.dp)
                )
                .padding(top = 8.dp, start = 12.dp, bottom = 8.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_gallery),
            contentDescription = "Photos",
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun FinalRow(id: Int, description: String, text: String) {

    Row(verticalAlignment = Alignment.CenterVertically) {

        Image(
            painter = painterResource(id = id),
            contentDescription = description,
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, fontSize = 18.sp, color = Color.Gray)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RowPreview() {
    ThirdRow()
}