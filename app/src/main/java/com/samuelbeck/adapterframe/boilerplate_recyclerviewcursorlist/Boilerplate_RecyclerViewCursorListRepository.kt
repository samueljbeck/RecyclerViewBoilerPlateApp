//TODO: update package name
package com.samuelbeck.adapterframe.boilerplate_recyclerviewcursorlist

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.samuelbeck.adapterframe.DbUtils

/*
 * Created by samueljbeck on 1/4/19.
 */


//TODO: change class name
class Boilerplate_RecyclerViewCursorListRepository(private val dataBase: SQLiteDatabase) {

    // add classes for accessing data

    fun getExampleData(count: Int): Cursor? {
        val selectQuery = "SELECT * " +
                " FROM example_data " +
                " ORDER BY _id "

        return DbUtils.runSelectQuery(selectQuery, dataBase)
    }


}