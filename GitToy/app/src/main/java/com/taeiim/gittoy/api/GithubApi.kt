package com.taeiim.gittoy.api

import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.api.model.GithubUser
import com.taeiim.gittoy.api.model.RepoSearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories")
    fun searchRepository(@Query("q") query: String): Single<RepoSearchResponse>

    @GET("repos/{owner}/{repo}")
    fun getRepoInfo(@Path("owner") userName: String, @Path("repo") repo: String): Single<GithubRepo>

    @GET("users/{name}")
    fun getUserInfo(@Path("name") userName: String): Single<GithubUser>

}