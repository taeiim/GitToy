package com.taeiim.gittoy.di

import com.taeiim.gittoy.data.GithubRepository
import com.taeiim.gittoy.data.GithubRepositoryImpl
import com.taeiim.gittoy.data.source.GithubDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideGithubRepository(
        remoteGithubDataSource: GithubDataSource.Remote,
        localGithubDataSource: GithubDataSource.Local
    ): GithubRepository {
        return GithubRepositoryImpl(remoteGithubDataSource, localGithubDataSource)
    }

}
