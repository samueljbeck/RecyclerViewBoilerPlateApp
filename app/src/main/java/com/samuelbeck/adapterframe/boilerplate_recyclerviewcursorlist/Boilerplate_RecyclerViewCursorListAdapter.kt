//TODO: update package name
package com.samuelbeck.adapterframe.boilerplate_recyclerviewcursorlist

import android.app.Activity
import android.database.Cursor
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samuelbeck.adapterframe.R
import com.samuelbeck.adapterframe.recyclerviewcursorlist.RecyclerViewCursorListAdapter
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import com.samuelbeck.adapterframe.util.CursorRecyclerAdapter

/*
 * Created by samueljbeck on 1/4/19.
 */

//TODO: update class name
class Boilerplate_RecyclerViewCursorListAdapter(private val thisInterface: RecyclerCursorListAdapterInterface, cursor: Cursor?): CursorRecyclerAdapter<Boilerplate_RecyclerViewCursorListAdapter.ViewHolder>(cursor) {

    inner class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v)

    override fun onBindViewHolderCursor(holder: ViewHolder, cursor: Cursor) {

        //holder.v.item_num_text.text = cursor.getString(cursor.getColumnIndex("_id"))

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Boilerplate_RecyclerViewCursorListAdapter.ViewHolder {
        //TODO: replace item xml
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(itemView)
    }

    //TODO: Change interface name
    interface RecyclerCursorListAdapterInterface {
        fun thisActivity(): Activity

        //TODO: replace these clases
        fun getMoreItems(count: Int)
        fun resetItems()
    }

}