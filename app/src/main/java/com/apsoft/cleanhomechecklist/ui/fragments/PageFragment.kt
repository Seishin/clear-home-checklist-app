package com.apsoft.cleanhomechecklist.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apsoft.cleanhomechecklist.R
import com.apsoft.cleanhomechecklist.config.Constants
import com.apsoft.cleanhomechecklist.datasource.models.Task
import com.apsoft.cleanhomechecklist.di.components.ChecklistPageComponent
import com.apsoft.cleanhomechecklist.di.modules.ChecklistPageModule
import com.apsoft.cleanhomechecklist.ui.activities.MainActivity
import com.apsoft.cleanhomechecklist.ui.adapters.TasksAdapter
import com.xw.repo.BubbleSeekBar


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
class PageFragment: Fragment() {
    private val TAG: String = PageFragment::class.java.simpleName

    lateinit var contentView: View

    val data: ArrayList<Task> = ArrayList<Task>(0)

    lateinit var progressBar: BubbleSeekBar
    lateinit var tasksList: RecyclerView

    lateinit var tasksAdapter: TasksAdapter

    val component: ChecklistPageComponent by lazy {
        (activity as MainActivity).component.plus(ChecklistPageModule(this))
    }

    companion object {
        @JvmStatic
        fun newInstance(type: Int): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putInt(Constants.PAGES_KEY_TYPE, type)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contentView = inflater!!.inflate(R.layout.fragment_page, container, false)
        component.inject(this)

        component.database().taskRepository().getAll().subscribe({
            val data = ArrayList<Task>(0)
            for (task in it) {
                data.add(task)
            }
            populateData(data)
        })

        when (arguments.getInt(Constants.PAGES_KEY_TYPE)) {
            Constants.PAGES_DAILY -> {
//                TODO("DAILY TASKS")
            }

            Constants.PAGES_WEEKLY -> {
//                TODO("WEEKLY TASKS")
            }

            Constants.PAGES_MONTHLY -> {
//                TODO("PAGES TASKS")
            }
        }

        initUI()

        return contentView
    }

    private fun initUI() {
        tasksList = contentView.findViewById(R.id.list_tasks)
        progressBar = contentView.findViewById(R.id.progress_bar)

        tasksAdapter = TasksAdapter(activity.applicationContext)

        tasksList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        tasksList.adapter = tasksAdapter
    }

    private fun populateData(data: ArrayList<Task>) {
        tasksAdapter.setData(data)
    }
}