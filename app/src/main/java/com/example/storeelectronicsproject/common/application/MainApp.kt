package com.example.storeelectronicsproject.common.application

import android.app.Application

class MainApp : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}