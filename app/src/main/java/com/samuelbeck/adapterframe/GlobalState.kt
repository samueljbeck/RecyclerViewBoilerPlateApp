package com.samuelbeck.adapterframe

import android.app.Application
import android.util.Log
import com.squareup.leakcanary.LeakCanary

/*
 * Created by samueljbeck on 1/4/19.
 *
 */
class GlobalState: Application() {
    lateinit var dbmgr: DbMgr

    override  fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return
            }
            LeakCanary.install(this)
        }

        try {
            dbmgr = DbMgr(this)
        } catch (err: Exception) {
            Log.e(this.javaClass.simpleName, err.message)
        }

    }
}