package com.taeiim.gittoy.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.taeiim.gittoy.api.GithubApi
import com.taeiim.gittoy.data.source.GithubDataSource
import com.taeiim.gittoy.data.source.local.GithubLocalDataSourceImpl
import com.taeiim.gittoy.data.source.local.SearchRepoHistoryDao
import com.taeiim.gittoy.data.source.local.SearchRepoHistoryDatabase
import com.taeiim.gittoy.data.source.remote.GithubRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {
    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): SearchRepoHistoryDatabase {
        return Room.databaseBuilder(
            application,
            SearchRepoHistoryDatabase::class.java, SearchRepoHistoryDatabase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideSearchHistoryDao(@NonNull database: SearchRepoHistoryDatabase): SearchRepoHistoryDao {
        return database.searchHistoryDao()
    }

    @Provides
    @Singleton
    fun provideGithubLocalDataSource(@NonNull historyDao: SearchRepoHistoryDao): GithubDataSource.Local {
        return GithubLocalDataSourceImpl(historyDao)
    }

    @Provides
    @Singleton
    fun provideGithubRemoteDataSource(@NonNull githubApi: GithubApi): GithubDataSource.Remote {
        return GithubRemoteDataSourceImpl(githubApi)
    }

}
