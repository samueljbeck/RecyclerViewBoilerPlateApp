package com.samuelbeck.adapterframe.boilerplate_recyclerviewcursorlist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

/*
 * Created by samueljbeck on 1/4/19.
 */

class Boilerplate_RecyclerViewCursorListViewModel: ViewModel() {

    private lateinit var exampleData: MutableLiveData<Cursor>
    private lateinit var dataBase: SQLiteDatabase
    private var resetCount: Int = 25 //initial value

    fun getExampleData(count: Int, dataBase: SQLiteDatabase): LiveData<Cursor> {
        if (!::exampleData.isInitialized) {
            this.dataBase = dataBase
            exampleData = MutableLiveData()
        }

        exampleData.value = Boilerplate_RecyclerViewCursorListRepository(dataBase).getExampleData(count)
        return exampleData
    }


    fun getMoreData(count: Int) {
        exampleData.value = Boilerplate_RecyclerViewCursorListRepository(dataBase).getExampleData(count)
    }

    fun resetItems() {
        Boilerplate_RecyclerViewCursorListRepository(dataBase).setExampleData(resetCount)
        exampleData.value = Boilerplate_RecyclerViewCursorListRepository(dataBase).getExampleData(resetCount)
    }


}