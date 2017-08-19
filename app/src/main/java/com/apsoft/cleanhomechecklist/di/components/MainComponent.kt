package com.apsoft.cleanhomechecklist.di.components

import com.apsoft.cleanhomechecklist.datasource.AppDatabase
import com.apsoft.cleanhomechecklist.di.modules.MainModule
import com.apsoft.cleanhomechecklist.di.scopes.ActivityScope
import com.apsoft.cleanhomechecklist.ui.activities.MainActivity
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
@ActivityScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)

    fun database(): AppDatabase
}