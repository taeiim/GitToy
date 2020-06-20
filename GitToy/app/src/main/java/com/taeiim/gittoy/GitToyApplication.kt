package com.taeiim.gittoy

import com.facebook.stetho.Stetho
import com.taeiim.gittoy.di.DaggerAppComponent
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector

class GitToyApplication : DaggerApplication(), HasAndroidInjector {

    private val appComponent = DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }

    override fun applicationInjector() = appComponent

}