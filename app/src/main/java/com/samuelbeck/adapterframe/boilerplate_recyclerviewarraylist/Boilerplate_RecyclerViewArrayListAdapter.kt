//TODO: update package name
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

//TODO: update class name
class Boilerplate_RecyclerViewArrayListAdapter(var thisInterface: RecyclerArrayListAdapterInterface, var items: ArrayList<String>): RecyclerView.Adapter<Boilerplate_RecyclerViewArrayListAdapter.ViewHolder>() {

    inner class ViewHolder(val v: View) : RecyclerView.ViewHolder(v)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //TODO: replace item xml
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface RecyclerArrayListAdapterInterface {
        fun thisActivity(): Activity

        //TODO: replace these functions
        fun getMoreItems(count: Int)
        fun resetItems()
    }

}