package com.apsoft.cleanhomechecklist.di.modules

import com.apsoft.cleanhomechecklist.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
@Module
class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideApp() = app
}