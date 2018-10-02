package com.example.hadevs.projectlocation.Acitivities

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.EditText
import com.example.hadevs.projectlocation.Extensions.add
import com.example.hadevs.projectlocation.Extensions.setActionBarWith
import com.example.hadevs.projectlocation.Formatters.PhoneFormatter
import com.example.hadevs.projectlocation.Formatters.SMSFormatter
import com.example.hadevs.projectlocation.R

class ConfirmSMSActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_sms)
        val title = resources.getString(R.string.agent_screen_title)
        setActionBarWith(supportActionBar, title)
        addFormattersToFields()
    }

    private fun addFormattersToFields() {
        val phoneField = findViewById<EditText>(R.id.editText)
        phoneField.add(PhoneFormatter)

        val smsField = findViewById<EditText>(R.id.smsEditText)
        smsField.add(SMSFormatter)
    }

}
