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


class RecyclerViewArrayListAdapter(var thisInterface: RecyclerArrayListAdapterInterface, var items: ArrayList<ExampleData>): RecyclerView.Adapter<RecyclerViewArrayListAdapter.ViewHolder>() {

    inner class ViewHolder(val v: View) : RecyclerView.ViewHolder(v)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.v.item_num_text.text = item.num.toString()
        holder.v.item_text.text = item.item

        if (position == 0) {
            holder.v.item_holder.setOnClickListener {
                thisInterface.resetItems()
            }
        } else if (position < items.size - 1) {
            holder.v.item_holder.setOnClickListener {  }
        } else { //last item
            holder.v.item_holder.setOnClickListener {
                thisInterface.getMoreItems(25)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false))
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