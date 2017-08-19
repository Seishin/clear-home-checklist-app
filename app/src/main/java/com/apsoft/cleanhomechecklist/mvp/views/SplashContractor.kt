package com.apsoft.cleanhomechecklist.mvp.views

import com.apsoft.cleanhomechecklist.datasource.models.Task


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
interface SplashContractor: Contractor {
    fun onInsertionSucceeds()
}