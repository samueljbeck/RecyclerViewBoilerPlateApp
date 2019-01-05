package com.samuelbeck.adapterframe

/*
 * Created by samueljbeck on 1/4/19.
 */

import android.database.Cursor
import android.database.MatrixCursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log

import java.util.ArrayList


class DbUtils {

    fun getData(Query: String, dataBase: SQLiteDatabase): ArrayList<Cursor?> {
        //get writable database
        val columns = arrayOf("mesage")
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        val alc = ArrayList<Cursor?>(2)
        val cursor2 = MatrixCursor(columns)
        alc.add(null)
        alc.add(null)


        try {
        //execute the query results will be save in Cursor c
            val c = dataBase.rawQuery(Query, null)


            //add value to cursor2
            cursor2.addRow(arrayOf<Any>("Success"))

            alc[1] = cursor2
            if (null != c && c.count > 0) {


                alc[0] = c
                c.moveToFirst()

                c.close()
                return alc
            }
            c.close()
            return alc
        } catch (ex: Exception) {

            Log.d("printing exception", ex.message)

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            cursor2.addRow(arrayOf<Any>("" + ex.message))
            alc[1] = cursor2
            return alc
        }


    }

    companion object {

        private const val TAG = "DbUtils"


        fun booleanToInt(b: Boolean?): Int? {
            if (b == null) {
                return null
            }
            return if (b) 1 else 0
        }

        fun intToBoolean(i: Int?): Boolean {
            return i != null && i > 0
        }

        fun booleanToString(b: Boolean?): String {
            if (b == null) {
                return "false"
            }
            return if (b) "true" else "false"
        }

        fun stringToBoolean(i: String?): Boolean {
            return i != null && i == "true"
        }

        fun getTableColumnNames(table: String, dataBase: SQLiteDatabase) {
            val ti = dataBase.rawQuery("PRAGMA table_info($table)", null)
            if (ti.moveToFirst()) {
                do {
                    println("col: " + ti.getString(1))
                } while (ti.moveToNext())
            }
            ti.close()

        }

        fun deleteQuery(deleteQuery: String, dataBase: SQLiteDatabase) {
            try {
                dataBase.execSQL(deleteQuery)
            } catch (err: Exception) {
                Log.e(TAG, "delete " + deleteQuery + " failed : " + err.message)
            }

        }

        fun runSelectQuery(selectQuery: String, dataBase: SQLiteDatabase): Cursor? {
            var cursor: Cursor? = null
            try {
                cursor = dataBase.rawQuery(selectQuery, null)
            } catch (err: Exception) {
                Log.e(TAG, "SQLException in cursor call : " + err.message)
                cursor?.close()
                return null
            }

            return cursor

        }

        fun fieldEntryString(count: Int): String {
            var fields = "?"
            for (i in 1 until count) {
                fields = "$fields,?"
            }
            return fields
        }
    }

}

