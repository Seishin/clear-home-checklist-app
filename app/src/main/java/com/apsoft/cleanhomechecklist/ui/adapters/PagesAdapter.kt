package com.apsoft.cleanhomechecklist.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.apsoft.cleanhomechecklist.ui.PageFragment


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/18/17.
 **
 ** APSoft 2017
 */

class PagesAdapter(var fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    private val PAGES_COUNT = 3

    override fun getItem(position: Int): Fragment {
        return PageFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return PAGES_COUNT;
    }

}