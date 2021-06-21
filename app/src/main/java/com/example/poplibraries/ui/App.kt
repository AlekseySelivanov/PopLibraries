package com.example.poplibraries.ui


import android.app.Application
import com.example.poplibraries.di.AppComponent
import com.example.poplibraries.di.modules.AppModule
import com.example.poplibraries.di.DaggerAppComponent


class App : Application() {
    companion object {
        lateinit var instance: App
        val component get() = instance.appComponent
    }

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}