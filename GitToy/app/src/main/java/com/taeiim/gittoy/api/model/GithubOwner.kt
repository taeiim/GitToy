package com.taeiim.gittoy.api.model


import com.google.gson.annotations.SerializedName

data class GithubOwner(
    @SerializedName("id")
    val ownerID: Int = 0,
    @SerializedName("login")
    val ownerName: String = "",
    @SerializedName("avatar_url")
    val profileImgUrl: String = ""
)