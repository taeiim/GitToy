package com.taeiim.gittoy.di

import com.taeiim.gittoy.ui.detail.DetailViewModel
import com.taeiim.gittoy.ui.main.MainViewModel
import com.taeiim.gittoy.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailViewModel(get()) }

}