package com.example.hadevs.projectlocation

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.EditText

class ConfirmSMSActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_sms)
        val title = resources.getString(R.string.agent_screen_title)
        setActionBarWith(supportActionBar, title)
        addPhoneFormatterToField()
    }

    private fun addPhoneFormatterToField() {
        val phoneField = findViewById<EditText>(R.id.editText)
        phoneField.add(PhoneFormatter)
    }

}
