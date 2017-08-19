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
import com.apsoft.cleanhomechecklist.ui.widgets.SmoothCheckBox


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */

class TasksAdapter(var context: Context): RecyclerView.Adapter<TasksAdapter.ViewHolder>() {

    private val tasksData: ArrayList<Task> = ArrayList<Task>(0)

    override fun getItemCount(): Int {
        return tasksData.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val task = tasksData[position]
        holder?.title?.text = task.title
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.layout_task, parent, false))
    }

    fun setData(data: ArrayList<Task>) {
        this.tasksData.clear()
        this.tasksData.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(var itemView: View): RecyclerView.ViewHolder(itemView) {
        val checkbox: SmoothCheckBox by bindView(R.id.checkbox)
        val title: TextView by bindView(R.id.title)
    }
}