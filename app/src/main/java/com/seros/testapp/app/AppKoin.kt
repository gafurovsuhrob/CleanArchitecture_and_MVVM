package com.seros.testapp.app

import android.app.Application
import com.seros.testapp.diKoin.appModule
import com.seros.testapp.diKoin.dataModule
import com.seros.testapp.diKoin.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AppKoin: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@AppKoin)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}