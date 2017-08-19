package com.apsoft.cleanhomechecklist.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.apsoft.cleanhomechecklist.R
import com.apsoft.cleanhomechecklist.config.Constants
import com.apsoft.cleanhomechecklist.di.components.SplashComponent
import com.apsoft.cleanhomechecklist.di.modules.SplashModule
import com.apsoft.cleanhomechecklist.mvp.views.Contractor


/**
 ** Created by Atanas Dimitrov <seishin90@yandex.ru>
 ** on 8/19/17.
 **
 ** APSoft 2017
 */
class SplashActivity: BaseActivity(), Contractor {

    val component: SplashComponent by lazy {
        app.component.plus(SplashModule(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        component.inject(this)

        if (component.sharedPrefs().getBoolean(Constants.KEY_FIRST_START, true)) {
            component.presenter().populateInitialData()
            component.sharedPrefs().edit().putBoolean(Constants.KEY_FIRST_START, false).apply()
        } else {
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }

    override fun onRequestStarted() {
    }

    override fun onRequestCompleted() {
        startMainActivity()
    }

    override fun onError(message: String) {
    }

    override fun getAppContext(): Context {
        return this.applicationContext
    }
}