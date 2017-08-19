package com.apsoft.cleanhomechecklist.mvp.models

import com.apsoft.cleanhomechecklist.datasource.AppDatabase
import com.apsoft.cleanhomechecklist.datasource.models.Task
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
class TasksModel @Inject constructor(var database: AppDatabase) {
    fun requestAllTasks(): Flowable<Array<Task>> {
        return database.taskRepository().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    fun populateInitialData() {
        val initialData: ArrayList<Task> = ArrayList<Task>(0)
        initialData.add(Task("Test 1", 1))
        initialData.add(Task("Test 2", 2))
        database.taskRepository().insertAll(initialData)
    }
}