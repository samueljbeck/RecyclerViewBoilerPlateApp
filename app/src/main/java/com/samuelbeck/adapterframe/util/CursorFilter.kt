package com.samuelbeck.adapterframe.util

import android.database.Cursor
import android.widget.Filter

class CursorFilter internal constructor(private var mClient: CursorFilterClient) : Filter() {

    internal interface CursorFilterClient {
        var cursor: Cursor?
        fun convertToString(cursor: Cursor): CharSequence
        fun runQueryOnBackgroundThread(constraint: CharSequence): Cursor?
        fun changeCursor(cursor: Cursor)
    }

    override fun convertResultToString(resultValue: Any): CharSequence {
        return mClient.convertToString(resultValue as Cursor)
    }

    override fun performFiltering(constraint: CharSequence): Filter.FilterResults {
        val cursor = mClient.runQueryOnBackgroundThread(constraint)

        val results = Filter.FilterResults()
        if (cursor != null) {
            results.count = cursor.count
            results.values = cursor
        } else {
            results.count = 0
            results.values = null
        }
        return results
    }

    override fun publishResults(constraint: CharSequence, results: Filter.FilterResults) {
        val oldCursor = mClient.cursor

        if (results.values != null && results.values !== oldCursor) {
            mClient.changeCursor(results.values as Cursor)
        }
    }


}