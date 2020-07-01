package com.taeiim.gittoy.di

import android.content.Context
import androidx.room.Room
import com.taeiim.gittoy.api.GithubApi
import com.taeiim.gittoy.data.source.GithubDataSource
import com.taeiim.gittoy.data.source.local.GithubLocalDataSourceImpl
import com.taeiim.gittoy.data.source.local.SearchRepoHistoryDao
import com.taeiim.gittoy.data.source.local.SearchRepoHistoryDatabase
import com.taeiim.gittoy.data.source.remote.GithubRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataSourceModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SearchRepoHistoryDatabase {
        return Room.databaseBuilder(
            context,
            SearchRepoHistoryDatabase::class.java, SearchRepoHistoryDatabase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideSearchHistoryDao(database: SearchRepoHistoryDatabase): SearchRepoHistoryDao {
        return database.searchHistoryDao()
    }

    @Provides
    @Singleton
    fun provideGithubLocalDataSource(historyDao: SearchRepoHistoryDao): GithubDataSource.Local {
        return GithubLocalDataSourceImpl(historyDao)
    }

    @Provides
    @Singleton
    fun provideGithubRemoteDataSource(githubApi: GithubApi): GithubDataSource.Remote {
        return GithubRemoteDataSourceImpl(githubApi)
    }

}
