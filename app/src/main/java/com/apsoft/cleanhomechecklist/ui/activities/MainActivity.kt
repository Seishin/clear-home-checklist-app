package com.apsoft.cleanhomechecklist.ui.activities

import android.os.Bundle
import android.support.v4.view.ViewPager
import butterknife.bindView
import com.apsoft.cleanhomechecklist.R
import com.apsoft.cleanhomechecklist.di.components.MainComponent
import com.apsoft.cleanhomechecklist.di.modules.MainModule
import com.apsoft.cleanhomechecklist.ui.adapters.PagesAdapter
import com.gigamole.navigationtabstrip.NavigationTabStrip

class MainActivity : BaseActivity() {

    val tabs: NavigationTabStrip by bindView(R.id.tabs)
    val viewPager: ViewPager by bindView(R.id.pager)

    lateinit var pagesAdapter: PagesAdapter

    private val component: MainComponent by lazy {
        app.component.plus(MainModule(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        initUI()
    }

    private fun initUI() {
        pagesAdapter = PagesAdapter(supportFragmentManager)
        viewPager.adapter = pagesAdapter
        tabs.setViewPager(viewPager)
    }
}
