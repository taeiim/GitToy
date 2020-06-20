package com.taeiim.gittoy.api.model


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class GithubRepo(

    @SerializedName("description")
    var description: String = "",

    @SerializedName("disabled")
    var disabled: Boolean = false,

    @SerializedName("fork")
    var fork: Boolean = false,

    @SerializedName("forks")
    var forks: Int = 0,

    @SerializedName("forks_count")
    var forksCount: Int = 0,

    @SerializedName("full_name")
    var fullName: String = "",

    @SerializedName("id")
    var repoID: Int = 0,

    @SerializedName("name")
    var repoName: String = "",

    @Embedded
    @SerializedName("owner")
    var owner: GithubOwner = GithubOwner(),

    @SerializedName("private")
    var isPrivate: Boolean = false,

    @SerializedName("language")
    var language: String? = "",

    @SerializedName("stargazers_count")
    var starCnt: Int = 0,

    @SerializedName("updated_at")
    var updatedAt: String = "",

    @SerializedName("url")
    var url: String = ""

)