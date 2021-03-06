package com.samuelbeck.adapterframe.boilerplate_recyclerviewarraylist

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.samuelbeck.adapterframe.R
import com.samuelbeck.adapterframe.recyclerviewarraylist.Boilerplate_RecyclerViewArrayListAdapter
import com.samuelbeck.adapterframe.recyclerviewarraylist.Boilerplate_RecyclerViewArrayListViewModel
import kotlinx.android.synthetic.main.recycler_view_activity.*

/*
 * Created by samueljbeck on 1/4/19.
 *
 *
 * This is a sample ArrayList adapter implementation for RecyclerView
 *
 * It is stripped down to the very basics for easy grab and go implementation
 */


//TODO: update class name
class Boilerplate_RecyclerViewArrayListActivity: AppCompatActivity() {

    //TODO: Change name of adapter
    private lateinit var adapter: Boilerplate_RecyclerViewArrayListAdapter
    lateinit var layoutManager: LinearLayoutManager
    //TODO: Change name of ViewModel
    lateinit var viewModel: Boilerplate_RecyclerViewArrayListViewModel
    lateinit var thisActivity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO: Change activity layout
        setContentView(R.layout.recycler_view_activity)
        thisActivity = this


        layoutManager = LinearLayoutManager(this)
        //TODO: Change name of adapter
        adapter = Boilerplate_RecyclerViewArrayListAdapter(adapterInterface, ArrayList())

        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter


        //TODO: change name of ViewModel
        viewModel = ViewModelProviders.of(this).get(Boilerplate_RecyclerViewArrayListViewModel::class.java)
        viewModel.getExampleData(25).observe(this, Observer { listData ->
            updateAdapter(listData!!)
        })

    }

    private fun updateAdapter(listData: ArrayList<String>) {
        adapter.items = listData
        adapter.notifyDataSetChanged()
    }


    private val adapterInterface = object: Boilerplate_RecyclerViewArrayListAdapter.RecyclerArrayListAdapterInterface {
        override fun thisActivity(): Activity {
            return thisActivity
        }


        //TODO: replace these functions
        override fun resetItems() {
            viewModel.resetItems()
        }

        override fun getMoreItems(count: Int) {
            viewModel.getMoreData(count)
        }



    }

}