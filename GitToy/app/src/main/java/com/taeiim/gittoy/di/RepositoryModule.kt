package com.taeiim.gittoy.di

import com.taeiim.gittoy.data.GithubRepository
import com.taeiim.gittoy.data.GithubRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Provides
    abstract fun provideDataRepository(dataRepository: GithubRepositoryImpl): GithubRepository

}
