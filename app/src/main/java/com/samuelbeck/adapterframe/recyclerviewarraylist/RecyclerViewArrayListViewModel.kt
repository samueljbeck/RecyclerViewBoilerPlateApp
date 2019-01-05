package com.samuelbeck.adapterframe.recyclerviewarraylist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/*
 * Created by samueljbeck on 1/5/19.
 */
class RecyclerViewArrayListViewModel: ViewModel() {

    private lateinit var exampleData: MutableLiveData<ArrayList<ExampleData>>
    private var resetCount: Int = 25 //initial value
    private var currentCount: Int = 25

    fun getExampleData(count: Int): LiveData<ArrayList<ExampleData>> {
        if (!::exampleData.isInitialized) {
            exampleData = MutableLiveData()
            resetCount = count
            currentCount = count
        }

        exampleData.value = RecyclerViewArrayListRepository().getItems(currentCount)
        return exampleData
    }

    fun getMoreData(count: Int) {
        currentCount += count
        exampleData.value = RecyclerViewArrayListRepository().getItems(currentCount)
    }

    fun resetItems() {
        currentCount = resetCount
        exampleData.value = RecyclerViewArrayListRepository().getItems(currentCount)
    }

}