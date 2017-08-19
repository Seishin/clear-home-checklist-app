package com.apsoft.cleanhomechecklist.di.components

import android.content.SharedPreferences
import com.apsoft.cleanhomechecklist.di.modules.SplashModule
import com.apsoft.cleanhomechecklist.di.scopes.ActivityScope
import com.apsoft.cleanhomechecklist.mvp.presenters.TasksPresenter
import com.apsoft.cleanhomechecklist.ui.activities.SplashActivity
import dagger.Subcomponent


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
@ActivityScope
@Subcomponent(modules = arrayOf(SplashModule::class))
interface SplashComponent {
    fun inject(activity: SplashActivity)

    fun sharedPrefs(): SharedPreferences
    fun presenter(): TasksPresenter
}