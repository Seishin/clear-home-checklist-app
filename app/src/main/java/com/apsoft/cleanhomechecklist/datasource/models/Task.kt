package com.apsoft.cleanhomechecklist.datasource.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
@Entity(tableName = "Tasks")
data class Task(@ColumnInfo(name = "title") var title: String = "",
           @ColumnInfo(name = "type") var type: Int = -1) {

    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Int? = null
}