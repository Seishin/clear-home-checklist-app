package com.apsoft.cleanhomechecklist.datasource

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.apsoft.cleanhomechecklist.datasource.models.Task
import com.apsoft.cleanhomechecklist.datasource.repositories.TasksRepository


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */

@Database(entities = arrayOf(Task::class), version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun taskRepository(): TasksRepository

    companion object {
        val DB_NAME = "app_db"
        var dbInstance: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase? {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder<AppDatabase>(context.applicationContext, AppDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }
            return dbInstance
        }
    }
}