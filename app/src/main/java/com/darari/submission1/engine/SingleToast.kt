package com.darari.submission1.engine

import android.content.Context
import android.widget.Toast

object SingleToast {

    fun showAToast(context: Context, msg: String) {
        var t = Toast.makeText(context, "", Toast.LENGTH_SHORT)
        try {
            if (t.view.isShown)
                t.setText(msg)
            else {
                t.setText(msg)
                t.show()
            }
        } catch (ignored: Exception) {
            t = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
            t.show()
        }
    }

}