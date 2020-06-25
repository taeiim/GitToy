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
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.annotation.AnnotationRetention.RUNTIME

@Module
@InstallIn(ApplicationComponent::class)
object DataSourceModule {

    @Qualifier
    @Retention(RUNTIME)
    annotation class RemoteGithubDataSource

    @Qualifier
    @Retention(RUNTIME)
    annotation class LocalGithubDataSource

    @Singleton
    @RemoteGithubDataSource
    @Provides
    fun provideGithubRemoteDataSource(@NetworkModule.GithubApis githubApi: GithubApi): GithubDataSource.Remote {
        return GithubRemoteDataSourceImpl(githubApi)
    }

    @Singleton
    @LocalGithubDataSource
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
