package com.apsoft.cleanhomechecklist.di.modules

import com.apsoft.cleanhomechecklist.datasource.AppDatabase
import com.apsoft.cleanhomechecklist.di.scopes.ActivityScope
import com.apsoft.cleanhomechecklist.mvp.models.TasksModel
import com.apsoft.cleanhomechecklist.mvp.presenters.TasksPresenter
import com.apsoft.cleanhomechecklist.ui.activities.SplashActivity
import dagger.Module
import dagger.Provides


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
@Module
class SplashModule(var activity: SplashActivity) {

    @ActivityScope
    @Provides
    fun provideModel(database: AppDatabase): TasksModel {
        return TasksModel(database)
    }

    @ActivityScope
    @Provides
    fun providePresenter(model: TasksModel): TasksPresenter {
        return TasksPresenter(contractor = activity, model = model)
    }
}