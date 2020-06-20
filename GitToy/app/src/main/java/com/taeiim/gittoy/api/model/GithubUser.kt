package com.taeiim.gittoy.api.model

import com.google.gson.annotations.SerializedName


data class GithubUser(
    @SerializedName("bio")
    val bio: String = "",
    @SerializedName("blog")
    val blog: String = "",
    @SerializedName("company")
    val company: String = String(),
    @SerializedName("created_at")
    val createdAt: String = "",
    @SerializedName("email")
    val email: String = String(),
    @SerializedName("followers")
    val followers: Int = 0,
    @SerializedName("following")
    val following: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("location")
    val location: String = String(),
    @SerializedName("login")
    val login: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("public_gists")
    val publicGists: Int = 0,
    @SerializedName("public_repos")
    val publicRepos: Int = 0,
    @SerializedName("updated_at")
    val updatedAt: String = "",
    @SerializedName("avatar_url")
    val profileImgUrl: String = ""
)