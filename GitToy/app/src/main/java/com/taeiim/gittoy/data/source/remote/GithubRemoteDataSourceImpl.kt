package com.taeiim.gittoy.data.source.remote

import com.taeiim.gittoy.api.GithubApi
import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.api.model.GithubUser
import com.taeiim.gittoy.data.source.GithubDataSource
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class GithubRemoteDataSourceImpl(private val githubApi: GithubApi) : GithubDataSource.Remote {

    override fun searchRepository(query: String): Single<List<GithubRepo>> =
        githubApi.searchRepository(query)
            .map { it.items }
            .subscribeOn(Schedulers.io())

    override fun getRepoInfo(userName: String, repoName: String): Single<GithubRepo> =
        githubApi.getRepoInfo(userName, repoName)
            .subscribeOn(Schedulers.io())

    override fun getUserInfo(userName: String): Single<GithubUser> =
        githubApi.getUserInfo(userName)
            .subscribeOn(Schedulers.io())

}