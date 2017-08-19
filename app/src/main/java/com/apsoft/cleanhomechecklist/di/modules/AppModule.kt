package com.apsoft.cleanhomechecklist.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.apsoft.cleanhomechecklist.App
import com.apsoft.cleanhomechecklist.config.Constants
import com.apsoft.cleanhomechecklist.datasource.AppDatabase
import com.apsoft.cleanhomechecklist.di.scopes.ActivityScope
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

    @Provides
    @Singleton
    fun provideAppContext(): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase = AppDatabase.getDatabase(context)!!

    @Provides
    @Singleton
    fun provideSharePreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(Constants.SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE)
    }
}