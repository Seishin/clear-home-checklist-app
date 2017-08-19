package com.apsoft.cleanhomechecklist.utils

import android.content.Context

/**
 * Author : andy
 * Date   : 16/1/21 11:28
 * Email  : andyxialm@gmail.com
 * Github : github.com/andyxialm
 * Description : A custom CheckBox with animation for Android
 */
class CompatUtils {
    companion object {
        fun dp2px(context: Context, dipValue: Int): Int {
            val scale = context.resources.displayMetrics.density
            return (dipValue * scale + 0.5f).toInt()
        }
    }
}