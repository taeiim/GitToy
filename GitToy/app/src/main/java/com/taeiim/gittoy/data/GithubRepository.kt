package com.taeiim.gittoy.data

import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.api.model.GithubUser
import io.reactivex.Completable
import io.reactivex.Single

interface GithubRepository {

    fun searchRepository(query: String): Single<List<GithubRepo>>

    fun getRepoInfo(userName: String, repoName: String): Single<GithubRepo>

    fun getUserInfo(userName: String): Single<GithubUser>

    fun getRepoHistoryList(): Single<List<GithubRepo>>

    fun saveClickRepo(repo: GithubRepo): Completable

    fun deleteRepoHistory(repo: GithubRepo): Completable

}