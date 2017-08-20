package com.apsoft.cleanhomechecklist.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import com.apsoft.cleanhomechecklist.R
import com.apsoft.cleanhomechecklist.datasource.models.Task
import com.apsoft.cleanhomechecklist.datasource.models.WrappedTask
import com.apsoft.cleanhomechecklist.ui.widgets.SmoothCheckBox


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */

class TasksAdapter(var context: Context): RecyclerView.Adapter<TasksAdapter.ViewHolder>() {

    private val tasksData: ArrayList<WrappedTask> = ArrayList<WrappedTask>(0)

    override fun getItemCount(): Int {
        return tasksData.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val task = tasksData[position]

        if (holder is ItemViewHolder) {
            holder.title.text = task.task?.title
        } else if (holder is HeaderViewHolder) {
            holder.title.text = task.header?.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)

        if (viewType == 1) {
            return ItemViewHolder(inflater.inflate(R.layout.layout_task, parent, false))
        } else {
            return HeaderViewHolder(inflater.inflate(R.layout.layout_task_header, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (tasksData[position].header != null) 0 else 1
    }

    fun setData(data: ArrayList<WrappedTask>) {
        this.tasksData.clear()
        this.tasksData.addAll(data)
        notifyDataSetChanged()
    }

    abstract class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    class ItemViewHolder(itemView: View): ViewHolder(itemView) {
        val checkbox: SmoothCheckBox by bindView(R.id.checkbox)
        val title: TextView by bindView(R.id.title)
    }

    class HeaderViewHolder(itemView: View): ViewHolder(itemView) {
        val title: TextView by bindView(R.id.title)
    }
}