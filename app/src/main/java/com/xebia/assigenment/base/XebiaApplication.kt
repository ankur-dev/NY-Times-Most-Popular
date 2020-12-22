package com.xebia.assigenment.base


import android.app.Application
import com.xebia.assigenment.di.appModule
import com.xebia.assigenment.di.repoModule
import com.xebia.assigenment.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class XebiaApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@XebiaApplication)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}