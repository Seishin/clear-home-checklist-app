package com.apsoft.cleanhomechecklist.mvp.presenters

import com.apsoft.cleanhomechecklist.datasource.models.Header
import com.apsoft.cleanhomechecklist.datasource.models.Task
import com.apsoft.cleanhomechecklist.datasource.models.WrappedTask
import com.apsoft.cleanhomechecklist.mvp.models.TasksModel
import com.apsoft.cleanhomechecklist.mvp.views.Contractor
import com.apsoft.cleanhomechecklist.mvp.views.TasksContractor
import javax.inject.Inject


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
class TasksPresenter @Inject constructor(var contractor: Contractor, var model: TasksModel) {

    fun requestAllTasks() {
        contractor.onRequestStarted()

        model.requestAllTasks().subscribe ({
            contractor.onRequestCompleted()
            (contractor as TasksContractor).onRequestDataReceived(formatData(it.toCollection(ArrayList())))
        }, {
            contractor.onError(it.localizedMessage)
        })
    }

    fun populateInitialData() {
        model.populateInitialData(contractor.getAppContext())
        contractor.onRequestCompleted()
    }

    private fun formatData(data: ArrayList<Task>): ArrayList<WrappedTask> {
        val tasks: ArrayList<WrappedTask> = ArrayList<WrappedTask>(0)

        tasks.add(WrappedTask(null, Header("Kitchen", room = 0)))
        for (task in data.filter { it.room == 0 }) {
            tasks.add(WrappedTask(task, null))
        }

        tasks.add(WrappedTask(null, Header("Living room", room = 1)))
        for (task in data.filter { it.room == 1 }) {
            tasks.add(WrappedTask(task, null))
        }

        tasks.add(WrappedTask(null, Header("Bedroom", room = 2)))
        for (task in data.filter { it.room == 2 }) {
            tasks.add(WrappedTask(task, null))
        }

        tasks.add(WrappedTask(null, Header("Bathroom / Laundry room", room = 3)))
        for (task in data.filter { it.room == 3 }) {
            tasks.add(WrappedTask(task, null))
        }

        return tasks
    }
}