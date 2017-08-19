package com.apsoft.cleanhomechecklist.di.modules

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.apsoft.cleanhomechecklist.di.scopes.FragmentScope
import dagger.Module
import dagger.Provides


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
@Module
class ChecklistPageModule(private val fragment: Fragment) {

    @FragmentScope
    @Provides
    fun provideAppContext() = fragment.activity.applicationContext

    @FragmentScope
    @Provides
    fun provideActivity() = fragment.activity
}