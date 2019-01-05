package com.samuelbeck.adapterframe


import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.samuelbeck.adapterframe.recyclerviewarraylist.ExampleData

/*
 * Created by samuelbeck on 10/20/15.
 *
 * when database tables are updated increase dbVersion by in build.config
 */
class DbMgr(context: Context) : SQLiteOpenHelper(context, "recyclerview.db", null, BuildConfig.dbVersion) {

    var dataBase: SQLiteDatabase = this.writableDatabase
    private var dbTbls: DbTbls? = null
    companion object {
        private const val TAG = "DbMgr"
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // setupDBTables();
        dbTbls = DbTbls(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //super.onDowngrade(db, oldVersion. newVersion);    //To change body of overridden methods use File | Settings | File Templates.
    }

    override fun onCreate(db: SQLiteDatabase) {
        // this gets called only if the DB doesn't exist on a call to getReadable/getWritable DB fails
        dbTbls = DbTbls(db)
    }


    @Throws(SQLException::class)
    fun purgeDataBases() {
        dbTbls = DbTbls(dataBase)
    }



    //used for saving api requests as bytearray (mainly used with protobuf calls)
    fun saveApiRequest(request: String, response: ByteArray, final: Boolean) {
        val sql = "INSERT OR REPLACE INTO api_requests VALUES (" + DbUtils.fieldEntryString(3) + ")"
        try {
            val statement = dataBase.compileStatement(sql)
            dataBase.beginTransaction()


            statement.clearBindings()
            statement.bindString(1, request)
            statement.bindBlob(2, response)
            statement.bindLong(3, DbUtils.booleanToInt(final)!!.toLong())

            statement.executeInsert()
            dataBase.setTransactionSuccessful()
            dataBase.endTransaction()
        } catch (err: Exception) {
            Log.e(TAG, err.message)
        }
    }

    fun getApiRequest(request: String) : ByteArray? {
        val selectQuery = "SELECT * " +
                " FROM api_requests " +
                " WHERE _id = '" + request + "'"
        val cursor = DbUtils.runSelectQuery(selectQuery, dataBase)
        return if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()
            cursor.getBlob(cursor.getColumnIndex("response"))
        } else {
            null
        }
    }

}
