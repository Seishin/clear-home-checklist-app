package com.apsoft.cleanhomechecklist.mvp.presenters

import com.apsoft.cleanhomechecklist.mvp.models.TasksModel
import com.apsoft.cleanhomechecklist.mvp.views.TasksContractor
import javax.inject.Inject


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
class TasksPresenter @Inject constructor(var contractor: TasksContractor, var model: TasksModel) {

    fun requestAllTasks() {
        contractor.onRequestStarted()

        model.requestAllTasks().subscribe ({
            contractor.onRequestCompleted()
            contractor.onRequestDataReceived(it.toCollection(ArrayList()))
        }, {
            contractor.onError(it.localizedMessage)
        })
    }
}