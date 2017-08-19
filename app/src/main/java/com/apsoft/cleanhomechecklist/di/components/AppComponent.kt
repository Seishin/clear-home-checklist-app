package com.apsoft.cleanhomechecklist.di.components

import com.apsoft.cleanhomechecklist.App
import com.apsoft.cleanhomechecklist.di.modules.AppModule
import com.apsoft.cleanhomechecklist.di.modules.MainModule
import com.apsoft.cleanhomechecklist.di.modules.SplashModule
import dagger.Component
import javax.inject.Singleton


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)

    fun plus(splashModule: SplashModule): SplashComponent
    fun plus(mainModule: MainModule): MainComponent
}