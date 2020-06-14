package com.taeiim.gittoy.data.source.local

import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.data.source.GithubDataSource
import com.taeiim.gittoy.data.source.local.model.SearchRepoHistory
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class GithubLocalDataSourceImpl(
    private val historyDao: SearchRepoHistoryDao
) : GithubDataSource.Local {

    override fun getRepoHistoryList(): Single<List<GithubRepo>> =
        historyDao.getRepoHistoryList()
            .toSingle()
            .subscribeOn(Schedulers.io())

    override fun saveClickRepo(repo: GithubRepo): Completable =
        historyDao.saveClickRepo(SearchRepoHistory(repo))
            .subscribeOn(Schedulers.io())

    override fun deleteRepoHistory(repo: GithubRepo): Completable =
        historyDao.deleteRepoHistory(SearchRepoHistory(repo))
            .subscribeOn(Schedulers.io())

}