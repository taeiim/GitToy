package com.taeiim.gittoy.di

import android.content.Context
import androidx.room.Room
import com.taeiim.gittoy.api.GithubApi
import com.taeiim.gittoy.data.source.GithubDataSource
import com.taeiim.gittoy.data.source.local.GithubLocalDataSourceImpl
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
object DataSourceModule {

    @Singleton
    @Provides
    fun provideGithubRemoteDataSource(githubApi: GithubApi): GithubDataSource.Remote {
        return GithubRemoteDataSourceImpl(githubApi)
    }

    @Singleton
    @Provides
    fun provideGithubDataSource(
        database: SearchRepoHistoryDatabase
    ): GithubDataSource.Local {
        return GithubLocalDataSourceImpl(
            database.searchHistoryDao()
        )
    }

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): SearchRepoHistoryDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            SearchRepoHistoryDatabase::class.java,
            SearchRepoHistoryDatabase.DB_NAME
        ).build()
    }
}
