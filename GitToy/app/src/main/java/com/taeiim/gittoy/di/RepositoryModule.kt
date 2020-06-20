package com.taeiim.gittoy.di

import com.taeiim.gittoy.data.GithubRepository
import com.taeiim.gittoy.data.GithubRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideDataRepository(dataRepository: GithubRepositoryImpl): GithubRepository

}
