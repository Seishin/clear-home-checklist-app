package com.apsoft.cleanhomechecklist.mvp.models

import android.content.Context
import com.apsoft.cleanhomechecklist.datasource.AppDatabase
import com.apsoft.cleanhomechecklist.datasource.models.Task
import com.apsoft.cleanhomechecklist.utils.JsonConverters
import com.google.gson.reflect.TypeToken
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.reflect.Type
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

    fun populateInitialData(context: Context) {
        val type: Type = object : TypeToken<List<Task>>() {}.type
        val initialData: List<Task>? = JsonConverters<Task>().convertJsonToArrayList(context, "tasks.json", type)
        if (initialData != null) {
            database.taskRepository().insertAll(initialData)
        }
    }
}