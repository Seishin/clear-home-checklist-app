package com.apsoft.cleanhomechecklist.datasource.repositories

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.apsoft.cleanhomechecklist.datasource.Repository
import com.apsoft.cleanhomechecklist.datasource.models.Task
import io.reactivex.Flowable


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
@Dao
abstract class TasksRepository: Repository<Task> {

    companion object {
        const val TABLE_NAME: String = "Tasks"
        const val ID: String = "id"
    }

    @Query("SELECT * FROM $TABLE_NAME WHERE $ID = :arg0")
    abstract fun getBy(id: String): Flowable<Task>

    @Query("SELECT * FROM $TABLE_NAME")
    abstract fun getAll(): Flowable<Array<Task>>

    @Insert
    abstract fun insertAll(initialData: List<Task>)
}