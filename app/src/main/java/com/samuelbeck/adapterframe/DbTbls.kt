package com.samuelbeck.adapterframe

import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import java.util.ArrayList

/**
 * Created by samuelbeck on 11/4/15.
 *
 *
 * when database tables are updated increase dbVersion by in build.config
 */


internal class DbTbls(private val realmDataBase: SQLiteDatabase) {

    init {
        setupDBTables()
    }

    private fun setupDBTables() {
        clearTables()
        //create String to create the table
        val createTables = ArrayList<String>()
        createTables.add(createExampleDataTable())// just add more tables here

        //clear the table   recreate them

        for (s in createTables) try {
            realmDataBase.execSQL(s)
        } catch (err: SQLException) {
            Log.e(this.javaClass.simpleName, "SQL exception in table check " + err.message)
        } catch (err: Exception) {
            Log.e(this.javaClass.simpleName, "General exception in table check " + err.message)
        }

    }

    private fun clearTables() {
        //create String to clear the table
        val checkTables = ArrayList<String>()
        checkTables.add("Drop TABLE if exists example_data") // add tables here to drop


        for (s in checkTables) {
            try {
                realmDataBase.execSQL(s)
            } catch (err: SQLException) {
                Log.e(this.javaClass.simpleName, "SQL exception in table check " + err.message)
            } catch (err: Exception) {
                Log.e(this.javaClass.simpleName, "General exception in table check " + err.message)
            }

        }


    }


    private fun createExampleDataTable(): String {
        return " CREATE TABLE example_data (" +
                "_id INTEGER NOT NULL, " +                //1
                "name TEXT, " +                 //2
                "PRIMARY KEY (_id)" +
                ")"
    }

}
