package com.samuelbeck.adapterframe

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.samuelbeck.adapterframe.recyclerviewcursorlist.RecyclerViewCursorListActivity
import com.samuelbeck.adapterframe.recyclerviewarraylist.RecyclerViewArrayListActivity
import kotlinx.android.synthetic.main.main_activity.*

/*
 * Created by samueljbeck on 1/5/19.
 */

class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        array_list_text.setOnClickListener {
            startActivity(Intent(this, RecyclerViewArrayListActivity::class.java))
        }

        cursor_list_text.setOnClickListener {
            startActivity(Intent(this, RecyclerViewCursorListActivity::class.java))
        }

    }

}