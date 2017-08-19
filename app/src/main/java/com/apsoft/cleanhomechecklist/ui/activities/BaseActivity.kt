package com.apsoft.cleanhomechecklist.ui.activities

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import com.apsoft.cleanhomechecklist.App


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {
    val AppCompatActivity.app: App
        get() = application as App
}