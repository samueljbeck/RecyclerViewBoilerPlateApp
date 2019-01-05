package com.samuelbeck.adapterframe.recyclerviewcursorlist

import android.app.Activity
import android.database.Cursor
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samuelbeck.adapterframe.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import com.samuelbeck.adapterframe.util.CursorRecyclerAdapter

/*
 * Created by samueljbeck on 1/4/19.
 */

class RecyclerViewCursorListAdapter(private val thisInterface: RecyclerCursorListAdapterInterface, cursor: Cursor?): CursorRecyclerAdapter<RecyclerViewCursorListAdapter.ViewHolder>(cursor) {

    inner class ViewHolder(val v: View) : RecyclerView.ViewHolder(v)

    override fun onBindViewHolderCursor(holder: ViewHolder, cursor: Cursor) {

        holder.v.item_num_text.text = cursor.getString(cursor.getColumnIndex("_id"))
        holder.v.item_text.text = cursor.getString(cursor.getColumnIndex("name"))

        if (cursor.isFirst) {
            holder.v.item_holder.setOnClickListener {
                thisInterface.resetItems()
            }
        } else if (cursor.position < cursor.count - 1) {
            holder.v.item_holder.setOnClickListener {  }
        } else { //last item
            holder.v.item_holder.setOnClickListener {
                thisInterface.getMoreItems(cursor.count + 25)
            }
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewCursorListAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(itemView)
    }

    interface RecyclerCursorListAdapterInterface {
        fun thisActivity(): Activity
        fun getMoreItems(count: Int)
        fun resetItems()
    }

}