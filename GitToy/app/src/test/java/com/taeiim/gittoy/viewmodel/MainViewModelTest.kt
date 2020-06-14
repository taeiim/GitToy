package com.taeiim.gittoy.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.taeiim.gittoy.api.GithubApi
import com.taeiim.gittoy.data.GithubRepository
import com.taeiim.gittoy.data.GithubRepositoryImpl
import com.taeiim.gittoy.data.source.GithubDataSource
import com.taeiim.gittoy.data.source.local.GithubLocalDataSourceImpl
import com.taeiim.gittoy.data.source.local.SearchRepoHistoryDao
import com.taeiim.gittoy.data.source.remote.GithubRemoteDataSourceImpl
import com.taeiim.gittoy.ui.main.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    private lateinit var githubRepository: GithubRepository
    private lateinit var githubRemoteDataSource: GithubDataSource.Remote
    private lateinit var githubLocalDataSource: GithubDataSource.Local

    private val githubApi = mock<GithubApi>()
    private val historyDao = mock<SearchRepoHistoryDao>()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        githubRemoteDataSource = GithubRemoteDataSourceImpl(githubApi)
        githubLocalDataSource = GithubLocalDataSourceImpl(historyDao)
        githubRepository = GithubRepositoryImpl(githubRemoteDataSource, githubLocalDataSource)
        viewModel = MainViewModel(githubRepository)
    }

    @Test
    fun loadRepoHistoryList() {

    }

}