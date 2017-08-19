package com.apsoft.cleanhomechecklist.mvp.views

import android.content.Context


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
interface Contractor {
    fun onRequestStarted()
    fun onRequestCompleted()
    fun onError(message: String)

    fun getAppContext(): Context
}