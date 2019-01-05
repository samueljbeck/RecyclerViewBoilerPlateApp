package com.samuelbeck.adapterframe.recyclerviewarraylist

/*
 * Created by samueljbeck on 1/5/19.
 */
class RecyclerViewArrayListRepository {
    fun getItems(count: Int): ArrayList<ExampleData> {
        val items = ArrayList<ExampleData>()
        var i = 0
        while (i <= count) {
            items.add(ExampleData())
            items[i].num = i
            items[i].item = "Item $i"
            i++
        }
        return items
    }
}