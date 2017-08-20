package com.apsoft.cleanhomechecklist.mvp.views

import com.apsoft.cleanhomechecklist.datasource.models.WrappedTask


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
interface TasksContractor: Contractor {
    fun onRequestDataReceived(data: ArrayList<WrappedTask>)
}