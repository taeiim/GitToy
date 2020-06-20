package com.taeiim.gittoy.api.model


import com.google.gson.annotations.SerializedName

data class RepoSearchResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean = false,
    @SerializedName("items")
    val items: List<GithubRepo> = listOf(),
    @SerializedName("total_count")
    val totalCount: Int = 0
)