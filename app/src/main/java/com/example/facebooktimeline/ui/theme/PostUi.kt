package com.example.facebooktimeline.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.facebooktimeline.R
import com.example.facebooktimeline.model.Post

@Composable
fun PostUI(post: Post) {
    ConstraintLayout {
        val (userImage, userName, time, ic_public, ic_options,
            postImage, postDescription, shares, commnets, interaction, finalRow, devider, exitPost) = createRefs()
        Image(
            painter = painterResource(id = post.userImage ?: 0),
            contentDescription = "User Image",

            modifier = Modifier
                .padding(top = 8.dp, end = 4.dp, start = 8.dp)
                .size(40.dp)
                .clip(CircleShape)
                .constrainAs(userImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Text(text = post.userName ?: "",
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier =
            Modifier
                .constrainAs(userName) {
                    top.linkTo(userImage.top)
                    start.linkTo(userImage.end)

                }
                .padding(top = 8.dp))

        Text(text = post.time ?: "", color = Color.Gray, modifier = Modifier
            .constrainAs(time) {
                top.linkTo(userName.bottom)
                start.linkTo(userName.start)
            }
            .padding(top = 2.dp)
        )

        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "options",
            tint = Color.Gray,
            modifier = Modifier
                .padding(8.dp)
                .size(30.dp)
                .rotate(90f)
                .constrainAs(ic_options) {
                    top.linkTo(userName.top)
                    end.linkTo(exitPost.start)
                })

        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Ignore this post",
            tint = Color.Gray,
            modifier = Modifier
                .padding(8.dp)
                .size(30.dp)
                .constrainAs(exitPost) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                })
        Image(
            painter = painterResource(id = R.drawable.ic_public),
            contentDescription = "Public",
            modifier = Modifier
                .padding(top = 8.dp, start = 4.dp)
                .size(20.dp)
                .constrainAs(ic_public) {
                    top.linkTo(time.top)
                    start.linkTo(time.end)
                    bottom.linkTo(time.bottom)
                }
        )

        Text(
            text = post.postTitle ?: "",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .constrainAs(postDescription) {
                    top.linkTo(userImage.bottom)
                    start.linkTo(parent.start)
                }
        )
        Image(
            painter = painterResource(id = post.postImage ?: 0),
            contentDescription = "post picture",
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(postImage) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(postDescription.bottom)
                }
        )
        Text(
            text = "${post.numberOfShares} shares",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp)
                .constrainAs(shares) {
                    start.linkTo(postImage.start)
                    top.linkTo(postImage.bottom)
                }
        )
        Text(
            text = "${post.numberOfComments} commnets",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp)
                .constrainAs(commnets) {
                    start.linkTo(shares.end)
                    top.linkTo(postImage.bottom)
                }
        )
        Row(modifier = Modifier
            .padding(8.dp)
            .constrainAs(interaction) {
                end.linkTo(parent.end)
                top.linkTo(postImage.bottom)
            }) {
            Text(
                text = "${post.numberOfInteractions}",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(end = 4.dp)
            )
            InteractImage(id = R.drawable.laugh, description = "laugh")
            InteractImage(id = R.drawable.favorite, description = "favourite")
            InteractImage(id = R.drawable.like, description = "like")
        }

        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .constrainAs(finalRow) {
                    start.linkTo(parent.start)
                    top.linkTo(shares.bottom)
                }, horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FinalRow(
                id = R.drawable.ic_like,
                description = "like",
                text = stringResource(R.string.like)
            )
            FinalRow(
                id = R.drawable.ic_whatsapp,
                description = "send",
                text = stringResource(R.string.send)
            )
            FinalRow(
                id = R.drawable.ic_comment,
                description = "comment",
                text = stringResource(R.string.comment)
            )
            FinalRow(
                id = R.drawable.ic_share,
                description = "share",
                text = stringResource(R.string.share)
            )
        }
        Row(modifier = Modifier
            .padding(bottom = 8.dp)
            .height(8.dp)
            .background(SecondDeviderColor)
            .fillMaxWidth()
            .constrainAs(devider) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                top.linkTo(finalRow.bottom)
            }) {}
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PostPreview() {
    PostUI(
        post = Post(
            "Mark Lee",
            R.drawable.unknown,
            "9:00 pm",
            "Hi there everyone I am here and I want to share everything with you",
            R.drawable.sea_pic,
            12,
            15,
            1000
        )
    )

}
