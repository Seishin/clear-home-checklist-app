package com.apsoft.cleanhomechecklist

import android.app.Application
import com.apsoft.cleanhomechecklist.di.components.AppComponent
import com.apsoft.cleanhomechecklist.di.components.DaggerAppComponent
import com.apsoft.cleanhomechecklist.di.modules.AppModule

/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}