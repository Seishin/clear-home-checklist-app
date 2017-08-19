package com.apsoft.cleanhomechecklist.di.modules

import com.apsoft.cleanhomechecklist.datasource.AppDatabase
import com.apsoft.cleanhomechecklist.di.scopes.FragmentScope
import com.apsoft.cleanhomechecklist.mvp.models.TasksModel
import com.apsoft.cleanhomechecklist.mvp.presenters.TasksPresenter
import com.apsoft.cleanhomechecklist.ui.fragments.PageFragment
import dagger.Module
import dagger.Provides


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
@Module
class ChecklistPageModule(var fragment: PageFragment) {

    @FragmentScope
    @Provides
    fun provideAppContext() = fragment.activity.applicationContext

    @FragmentScope
    @Provides
    fun provideActivity() = fragment.activity

    @FragmentScope
    @Provides
    fun provideModel(database: AppDatabase): TasksModel {
        return TasksModel(database)
    }

    @FragmentScope
    @Provides
    fun providePresenter(model: TasksModel): TasksPresenter {
        return TasksPresenter(contractor = fragment, model = model)
    }
}