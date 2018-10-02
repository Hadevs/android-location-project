package com.example.hadevs.projectlocation.Acitivities

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.Button
import android.widget.EditText
import com.example.hadevs.projectlocation.Extensions.add
import com.example.hadevs.projectlocation.Extensions.setActionBarWith
import com.example.hadevs.projectlocation.Formatters.PhoneFormatter
import com.example.hadevs.projectlocation.R


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = resources.getString(R.string.agent_screen_title)
        setActionBarWith(supportActionBar, title)
        startFormattingPhoneField()
        addRegisterButtonTarget()
    }

    private fun addRegisterButtonTarget() {
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            registerButtonClicked()
        }
    }

    private fun registerButtonClicked() {
        val intent = Intent(this, ConfirmSMSActivity::class.java)
        startActivity(intent)
        this.overridePendingTransition(0,0)
    }

    private fun startFormattingPhoneField() {
        val phoneField = findViewById<EditText>(R.id.editText)
        phoneField.add(PhoneFormatter)
    }
}