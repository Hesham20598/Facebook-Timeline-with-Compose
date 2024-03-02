package com.example.facebooktimeline.model

data class Post(
    val userName: String? = null,
    val userImage: Int? = null,
    val time: String? = null,
    val postTitle: String? = null,
    val postImage: Int? = null,
    val numberOfShares: Int? = null,
    val numberOfComments: Int? = null,
    val numberOfInteractions: Int? = null
)
