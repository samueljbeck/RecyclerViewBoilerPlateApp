//TODO: update package name
package com.samuelbeck.adapterframe.recyclerviewarraylist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/*
 * Created by samueljbeck on 1/5/19.
 */

//TODO: Change class name
class Boilerplate_RecyclerViewArrayListViewModel: ViewModel() {

    //TODO: replace return type
    private lateinit var exampleData: MutableLiveData<ArrayList<String>>

    // TODO: add and replace variables
    private var resetCount: Int = 25 //initial value
    private var currentCount: Int = 25


    //TODO: replace return type
    fun getExampleData(count: Int): LiveData<ArrayList<String>> {
        if (!::exampleData.isInitialized) {
            exampleData = MutableLiveData()
        }

        //TODO: replace repository name
        exampleData.value = Boilerplate_RecyclerViewArrayListRepository().getItems(currentCount)
        return exampleData
    }

    fun getMoreData(count: Int) {
        currentCount += count
        //TODO: replace repository name
        exampleData.value = Boilerplate_RecyclerViewArrayListRepository().getItems(currentCount)
    }

    fun resetItems() {
        currentCount = resetCount
        //TODO: replace repository name
        exampleData.value = Boilerplate_RecyclerViewArrayListRepository().getItems(currentCount)
    }

}