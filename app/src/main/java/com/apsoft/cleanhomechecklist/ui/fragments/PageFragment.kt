package com.apsoft.cleanhomechecklist.ui.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.apsoft.cleanhomechecklist.R
import com.apsoft.cleanhomechecklist.config.Constants
import com.apsoft.cleanhomechecklist.datasource.models.Task
import com.apsoft.cleanhomechecklist.di.components.ChecklistPageComponent
import com.apsoft.cleanhomechecklist.di.modules.ChecklistPageModule
import com.apsoft.cleanhomechecklist.mvp.views.TasksContractor
import com.apsoft.cleanhomechecklist.ui.activities.MainActivity
import com.apsoft.cleanhomechecklist.ui.adapters.TasksAdapter
import com.xw.repo.BubbleSeekBar
import javax.inject.Inject


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */
class PageFragment: Fragment(), TasksContractor {
    private val TAG: String = PageFragment::class.java.simpleName

    private lateinit var contentView: View

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

        initUI()

        component.presenter().requestAllTasks()

        return contentView
    }

    private fun initUI() {
        tasksList = contentView.findViewById(R.id.list_tasks)
        progressBar = contentView.findViewById(R.id.progress_bar)

        tasksAdapter = TasksAdapter(activity.applicationContext)

        tasksList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        tasksList.adapter = tasksAdapter
    }

    override fun onRequestStarted() {
        Toast.makeText(activity, "Request started...", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestCompleted() {
        Toast.makeText(activity, "Request completed...", Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onRequestDataReceived(data: ArrayList<Task>) {
        val filteredData: List<Task> = data.filter { it.type == arguments.getInt(Constants.PAGES_KEY_TYPE) }
        tasksAdapter.setData(filteredData as ArrayList<Task>)
    }

    override fun getAppContext(): Context {
        return activity.applicationContext
    }
}