package com.apsoft.cleanhomechecklist.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import com.apsoft.cleanhomechecklist.R
import com.apsoft.cleanhomechecklist.config.Constants
import com.apsoft.cleanhomechecklist.datasource.models.Task
import com.apsoft.cleanhomechecklist.ui.adapters.TasksAdapter
import com.xw.repo.BubbleSeekBar


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
class PageFragment: Fragment() {

    lateinit var contentView: View

    val data: ArrayList<Task> = ArrayList<Task>(0)

    lateinit var progressBar: BubbleSeekBar
    lateinit var tasksList: RecyclerView

    lateinit var tasksAdapter: TasksAdapter

    companion object {
        @JvmStatic
        fun newInstance(type: Int): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putInt(Constants.Pages.KEY_TYPE, type)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contentView = inflater!!.inflate(R.layout.fragment_page, container, false)

        when (arguments.getInt(Constants.Pages.KEY_TYPE)) {
            Constants.Pages.DAILY -> {
                data.add(Task("Sweep Floor", 0))
                data.add(Task("Wipe Down Counters", 0))
                data.add(Task("Wipe Down Stovetop", 0))
                data.add(Task("Empty Dishwasher", 0))
                data.add(Task("Load Dishwasher", 0))
            }

            Constants.Pages.WEEKLY -> {
                data.add(Task("Dust", 1))
                data.add(Task("Vacuum Cleaner", 1))
                data.add(Task("Wipe Down Cabinets", 1))
                data.add(Task("Wipe Down Appliances", 1))
            }

            Constants.Pages.MONTHLY -> {
                data.add(Task("Dust moldings", 2))
                data.add(Task("Dust ceiling fans", 2))
                data.add(Task("Clean blinds & curtains", 2))
                data.add(Task("Clean inside of oven", 2))
                data.add(Task("Wash inside of trash cans", 2))
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

        tasksAdapter.setData(data)
    }
}