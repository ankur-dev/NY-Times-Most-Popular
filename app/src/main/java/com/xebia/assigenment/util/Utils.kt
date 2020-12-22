package com.xebia.assigenment.util

import android.content.Context
import android.widget.Toast


class Utils {
    companion object {

        fun showToast(msg:String, context: Context){
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
        }
    }
}