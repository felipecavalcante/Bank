package com.example.bankapp.features.details.presentantion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bankapp.R

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }


    companion object {
        @JvmStatic
        fun createIntent(context: Context): Intent = Intent(context, DetailsActivity::class.java)
    }
}
