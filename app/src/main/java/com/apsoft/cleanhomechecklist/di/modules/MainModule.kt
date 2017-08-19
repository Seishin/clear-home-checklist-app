package com.apsoft.cleanhomechecklist.di.modules

import android.content.Context
import com.apsoft.cleanhomechecklist.datasource.AppDatabase
import com.apsoft.cleanhomechecklist.di.scopes.ActivityScope
import com.apsoft.cleanhomechecklist.ui.activities.MainActivity
import dagger.Module
import dagger.Provides


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
@Module
class MainModule(private val activity: MainActivity) {

    @Provides
    @ActivityScope
    fun provideAppContext(): Context {
        return activity.applicationContext
    }

    @Provides
    @ActivityScope
    fun provideDatabase(context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)!!
    }
}