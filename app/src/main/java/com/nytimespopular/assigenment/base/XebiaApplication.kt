package com.nytimespopular.assigenment.base


import android.app.Application
import com.nytimespopular.assigenment.di.appModule
import com.nytimespopular.assigenment.di.repoModule
import com.nytimespopular.assigenment.di.viewModelModule
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