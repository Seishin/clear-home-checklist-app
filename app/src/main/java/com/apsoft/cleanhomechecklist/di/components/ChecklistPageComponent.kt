package com.apsoft.cleanhomechecklist.di.components

import android.content.SharedPreferences
import com.apsoft.cleanhomechecklist.datasource.AppDatabase
import com.apsoft.cleanhomechecklist.di.modules.ChecklistPageModule
import com.apsoft.cleanhomechecklist.di.scopes.FragmentScope
import com.apsoft.cleanhomechecklist.mvp.presenters.TasksPresenter
import com.apsoft.cleanhomechecklist.ui.fragments.PageFragment
import dagger.Subcomponent


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
@FragmentScope
@Subcomponent(modules = arrayOf(ChecklistPageModule::class))
interface ChecklistPageComponent {
    fun inject(fragment: PageFragment)

    fun database(): AppDatabase
    fun sharedPreference(): SharedPreferences
    fun presenter(): TasksPresenter
}