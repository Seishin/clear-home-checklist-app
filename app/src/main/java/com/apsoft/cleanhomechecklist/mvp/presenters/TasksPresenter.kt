package com.apsoft.cleanhomechecklist.mvp.presenters

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
            (contractor as TasksContractor).onRequestDataReceived(it.toCollection(ArrayList()))
        }, {
            contractor.onError(it.localizedMessage)
        })
    }

    fun populateInitialData() {
        model.populateInitialData()
        contractor.onRequestCompleted()
    }
}