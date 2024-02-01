package com.seros.testapp.app

import android.app.Application
import com.seros.testapp.diDagger.AppComponent
import com.seros.testapp.diDagger.AppModule
import com.seros.testapp.diDagger.DaggerAppComponent

class AppDagger : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}