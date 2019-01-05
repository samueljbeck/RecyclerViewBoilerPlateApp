package com.samuelbeck.adapterframe.boilerplate_recyclerviewcursorlist

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.database.Cursor
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.samuelbeck.adapterframe.GlobalState
import com.samuelbeck.adapterframe.R
import com.samuelbeck.adapterframe.boilerplate_recyclerviewcursorlist.Boilerplate_RecyclerViewCursorListAdapter.RecyclerCursorListAdapterInterface
import kotlinx.android.synthetic.main.recycler_view_activity.*

/*
 * Created by samueljbeck on 1/4/19.
 *
 * This is a sample CursorAdapter implementation for RecyclerView
 *
 * It is stripped down to the very basics for easy grab and go implementation
 *
 * By using an interface to access an activity we eliminate the adapter holding onto the Activity (memory leak)
 * If we pass in activity to the adapter remember to set activity null in onDestroy
 *
 */

class Boilerplate_RecyclerViewCursorListActivity: AppCompatActivity() {

    private lateinit var adapter: Boilerplate_RecyclerViewCursorListAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var viewModel: Boilerplate_RecyclerViewCursorListViewModel
    lateinit var thisActivity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_activity)
        thisActivity = this


        layoutManager = LinearLayoutManager(this)
        adapter = Boilerplate_RecyclerViewCursorListAdapter(adapterInterface, null)

        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(Boilerplate_RecyclerViewCursorListViewModel::class.java)

        viewModel.getExampleData(25, (thisActivity.applicationContext as GlobalState).dbmgr.dataBase).observe(this, Observer { cursor ->
            updateAdapter(cursor)
        })


    }

    private fun updateAdapter(cursor: Cursor?) {
        if (cursor != null) {
            adapter.changeCursor(cursor)
            adapter.notifyDataSetChanged()
        }
    }

    private val adapterInterface = object: RecyclerCursorListAdapterInterface {
        override fun resetItems() {
            viewModel.resetItems()
        }

        override fun getMoreItems(count: Int) {
            viewModel.getMoreData(count)
        }

        override fun thisActivity(): Activity {
            return thisActivity
        }

    }

}