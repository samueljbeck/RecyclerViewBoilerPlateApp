package com.samuelbeck.adapterframe.recyclerviewarraylist

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
 * Created by samueljbeck on 1/4/19.
 */
class ExampleData {
    @SerializedName("num")
    @Expose
    var num: Int? = null


    @SerializedName("item")
    @Expose
    var item: String? = null
}