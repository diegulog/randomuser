package com.diegulog.randomuser

import android.app.Application
import com.diegulog.randomuser.di.appModule
import com.diegulog.randomuser.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@App)
            modules(listOf(appModule,viewModelModule))
        }
    }
}