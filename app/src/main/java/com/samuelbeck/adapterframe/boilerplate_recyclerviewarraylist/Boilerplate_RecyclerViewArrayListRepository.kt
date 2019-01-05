package com.samuelbeck.adapterframe.recyclerviewarraylist

import java.util.*

/*
 * Created by samueljbeck on 1/5/19.
 */
class Boilerplate_RecyclerViewArrayListRepository {
    fun getItems(count: Int): ArrayList<String> {
        val items = ArrayList<String>()
        var i = 0
        while (i <= count) {
            items.add(UUID.randomUUID().toString())
            i++
        }
        return items
    }
}