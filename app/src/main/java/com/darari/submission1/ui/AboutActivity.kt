package com.darari.submission1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.darari.submission1.R
import com.darari.submission1.engine.SingleToast

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        SingleToast.showAToast(this, "Mohon kasih feedback via email ya :)")
    }
}
