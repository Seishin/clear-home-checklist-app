package com.apsoft.cleanhomechecklist.datasource

import android.arch.persistence.room.*


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */

@Dao
interface Repository<in E> {
    @Insert
    fun insert(element: E)

    @Update
    fun update(element: E)

    @Delete
    fun remove(element: E)
}