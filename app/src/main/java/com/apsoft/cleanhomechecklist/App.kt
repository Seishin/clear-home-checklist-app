package com.apsoft.cleanhomechecklist

import android.app.Application
import com.apsoft.cleanhomechecklist.di.components.AppComponent
import com.apsoft.cleanhomechecklist.di.components.DaggerAppComponent

/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}