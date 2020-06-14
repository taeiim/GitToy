package com.taeiim.gittoy.di

import androidx.room.Room
import com.taeiim.gittoy.data.GithubRepository
import com.taeiim.gittoy.data.GithubRepositoryImpl
import com.taeiim.gittoy.data.source.GithubDataSource
import com.taeiim.gittoy.data.source.local.GithubLocalDataSourceImpl
import com.taeiim.gittoy.data.source.local.SearchRepoHistoryDatabase
import com.taeiim.gittoy.data.source.remote.GithubRemoteDataSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataSourceModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            SearchRepoHistoryDatabase::class.java, SearchRepoHistoryDatabase.DB_NAME
        ).build()
    }
    single { get<SearchRepoHistoryDatabase>().searchHistoryDao() }
    single<GithubDataSource.Local> { GithubLocalDataSourceImpl(get()) }
    single<GithubDataSource.Remote> { GithubRemoteDataSourceImpl(get()) }
    single<GithubRepository> { GithubRepositoryImpl(get(), get()) }
}
