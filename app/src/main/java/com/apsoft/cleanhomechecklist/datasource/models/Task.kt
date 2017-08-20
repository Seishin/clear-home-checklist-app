package com.apsoft.cleanhomechecklist.datasource.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
@Entity(tableName = "Tasks")
data class Task(@SerializedName("title") @ColumnInfo(name = "title") var title: String = "",
                @SerializedName("type") @ColumnInfo(name = "type") var type: Int = -1,
                @SerializedName("room") @ColumnInfo(name = "room") var room: Int = -1) {

    @Expose(deserialize = false, serialize = false)
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Int? = null
}