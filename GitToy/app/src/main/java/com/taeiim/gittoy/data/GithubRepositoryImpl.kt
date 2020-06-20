package com.taeiim.gittoy.data

import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.api.model.GithubUser
import com.taeiim.gittoy.data.source.GithubDataSource
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteDataSource: GithubDataSource.Remote,
    private val githubLocalDataSource: GithubDataSource.Local
) : GithubRepository {

    override fun searchRepository(query: String): Single<List<GithubRepo>> =
        githubRemoteDataSource.searchRepository(query)

    override fun getRepoInfo(userName: String, repoName: String): Single<GithubRepo> =
        githubRemoteDataSource.getRepoInfo(userName, repoName)

    override fun getUserInfo(userName: String): Single<GithubUser> =
        githubRemoteDataSource.getUserInfo(userName)

    override fun getRepoHistoryList(): Single<List<GithubRepo>> =
        githubLocalDataSource.getRepoHistoryList()

    override fun saveClickRepo(repo: GithubRepo): Completable =
        githubLocalDataSource.saveClickRepo(repo)

    override fun deleteRepoHistory(repo: GithubRepo): Completable =
        githubLocalDataSource.deleteRepoHistory(repo)

}