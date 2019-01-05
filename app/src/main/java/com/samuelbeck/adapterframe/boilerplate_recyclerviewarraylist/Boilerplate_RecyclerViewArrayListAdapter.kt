package com.samuelbeck.adapterframe.recyclerviewarraylist

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samuelbeck.adapterframe.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*

/*
 * Created by samueljbeck on 1/4/19.
 *
 *
 */


class Boilerplate_RecyclerViewArrayListAdapter(var thisInterface: RecyclerArrayListAdapterInterface, var items: ArrayList<String>): RecyclerView.Adapter<Boilerplate_RecyclerViewArrayListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false))
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val v = view
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface RecyclerArrayListAdapterInterface {
        fun thisActivity(): Activity
        fun getMoreItems(count: Int)
        fun resetItems()
    }

}