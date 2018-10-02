package com.example.hadevs.projectlocation.Activities

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import com.example.hadevs.projectlocation.Extensions.setActionBarWith
import com.example.hadevs.projectlocation.R

class OperatorCallActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operator_call)
        val title = resources.getString(R.string.agent_screen_title)
        setActionBarWith(supportActionBar, title)
    }
}
