package com.samuelbeck.adapterframe.recyclerviewarraylist

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.samuelbeck.adapterframe.R
import kotlinx.android.synthetic.main.recycler_view_activity.*

/*
 * Created by samueljbeck on 1/4/19.
 *
 *
 * This is a sample ArrayList adapter implementation for RecyclerView
 *
 * It is stripped down to the very basics for easy grab and go implementation
 */


class RecyclerViewArrayListActivity: AppCompatActivity() {

    private lateinit var adapter: RecyclerViewArrayListAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var viewModel: RecyclerViewArrayListViewModel
    lateinit var thisActivity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_activity)
        thisActivity = this


        layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewArrayListAdapter(adapterInterface, ArrayList())

        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(RecyclerViewArrayListViewModel::class.java)
        viewModel.getExampleData(25).observe(this, Observer { listData ->
            updateAdapter(listData!!)
        })

    }

    private fun updateAdapter(listData: ArrayList<ExampleData>) {
        adapter.items = listData
        adapter.notifyDataSetChanged()
    }


    private val adapterInterface = object: RecyclerViewArrayListAdapter.RecyclerArrayListAdapterInterface {
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