package com.taeiim.gittoy.di

import com.taeiim.gittoy.ui.detail.DetailActivity
import com.taeiim.gittoy.ui.main.MainActivity
import com.taeiim.gittoy.ui.search.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModuleBuilder {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailActivity

    @ContributesAndroidInjector
    abstract fun contributeSearchActivity(): SearchActivity
}
