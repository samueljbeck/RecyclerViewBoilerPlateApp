//TODO: update package name
package com.samuelbeck.adapterframe.boilerplate_recyclerviewcursorlist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

/*
 * Created by samueljbeck on 1/4/19.
 */

//TODO: Change class name
class Boilerplate_RecyclerViewCursorListViewModel: ViewModel() {


    private lateinit var exampleData: MutableLiveData<Cursor>
    private lateinit var dataBase: SQLiteDatabase

    // TODO: add and replace variables
    private var resetCount: Int = 25 //initial value

    fun getExampleData(): LiveData<Cursor> {
        if (!::exampleData.isInitialized) {
            this.dataBase = dataBase
            exampleData = MutableLiveData()
        }

        //TODO: replace repository name
        exampleData.value = Boilerplate_RecyclerViewCursorListRepository(dataBase).getExampleData(resetCount)
        return exampleData
    }


    fun getMoreData(count: Int) {

        //TODO: replace repository name
        exampleData.value = Boilerplate_RecyclerViewCursorListRepository(dataBase).getExampleData(count)
    }

    fun resetItems() {

        //TODO: replace repository name
        exampleData.value = Boilerplate_RecyclerViewCursorListRepository(dataBase).getExampleData(resetCount)
    }


}