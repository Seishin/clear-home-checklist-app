package com.apsoft.cleanhomechecklist.utils

import android.content.Context
import com.google.gson.GsonBuilder
import java.io.IOException
import java.lang.reflect.Type


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
class JsonConverters<E> {
    fun convertJsonToArrayList(context: Context, assetsFilePath: String, type: Type): ArrayList<E>? {
        var json: String? = null
        try {
            val inputStream = context.assets.open(assetsFilePath)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
        }

        return GsonBuilder().setPrettyPrinting().create().fromJson(json, type)
    }
}