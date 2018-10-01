package com.example.hadevs.projectlocation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ConfirmSMSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_sms)
        val title = resources.getString(R.string.agent_screen_title)
        setActionBarWith(supportActionBar, title)
    }
}
