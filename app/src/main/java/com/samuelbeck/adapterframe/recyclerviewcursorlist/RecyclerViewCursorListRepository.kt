package com.samuelbeck.adapterframe.recyclerviewcursorlist

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.samuelbeck.adapterframe.DbUtils
import com.samuelbeck.adapterframe.recyclerviewarraylist.ExampleData

/*
 * Created by samueljbeck on 1/4/19.
 */

class RecyclerViewCursorListRepository(private val dataBase: SQLiteDatabase) {

    fun getExampleData(count: Int): Cursor? {
        val selectQuery = "SELECT * " +
                " FROM example_data " +
                " ORDER BY _id "
        var cursor = DbUtils.runSelectQuery(selectQuery, dataBase)
        if (cursor == null || cursor.count < count) {

            setExampleData(count)
            cursor = DbUtils.runSelectQuery(selectQuery, dataBase)
        }
        return cursor
    }

    private fun saveExampleData(data: ArrayList<ExampleData>) {
        val sql = "INSERT OR REPLACE INTO example_data VALUES (" + DbUtils.fieldEntryString(2) + ")"
        try {
            val statement = dataBase.compileStatement(sql)
            dataBase.beginTransaction()

            for (item in data) {

                statement.clearBindings()

                statement.bindLong(1, item.num!!.toLong())
                if (item.item != null) {
                    statement.bindString(2, item.item)
                }

                statement.executeInsert()

            }
            dataBase.setTransactionSuccessful()
            dataBase.endTransaction()
        } catch (err: Exception) {
            Log.e(this.javaClass.simpleName, err.message)
        }

    }

    private fun clearExampleData() {
        val selectQuery = "DELETE FROM example_data"
        DbUtils.deleteQuery(selectQuery, dataBase)
    }

    fun setExampleData(count: Int) {
        clearExampleData()
        saveExampleData(getItems(count))
    }


    private fun getItems(count: Int): ArrayList<ExampleData> {
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