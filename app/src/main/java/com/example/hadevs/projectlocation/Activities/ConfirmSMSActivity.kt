package com.example.hadevs.projectlocation.Acitivities

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.Button
import android.widget.EditText
import com.example.hadevs.projectlocation.Extensions.add
import com.example.hadevs.projectlocation.Extensions.setActionBarWith
import com.example.hadevs.projectlocation.Formatters.PhoneFormatter
import com.example.hadevs.projectlocation.Formatters.SMSFormatter
import com.example.hadevs.projectlocation.Interactors.TimerInteractor
import com.example.hadevs.projectlocation.R
import android.graphics.Typeface
import android.R.id.button1
import android.graphics.Color
import android.support.v4.content.res.ResourcesCompat
import android.text.Html
import android.text.Spannable
import android.text.style.RelativeSizeSpan
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.TypefaceSpan
import com.example.hadevs.projectlocation.Help_files.CustomTypefaceSpan
import android.text.Spanned
import android.text.SpannableStringBuilder




class ConfirmSMSActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_sms)
        val title = resources.getString(R.string.agent_screen_title)
        setActionBarWith(supportActionBar, title)
        addFormattersToFields()
        startCounting()
    }

    private fun startCounting() {
        val timerInteractor = TimerInteractor(1, secondToLeft = 60)
        timerInteractor.loop {
            setSMSButton(getString(R.string.sendSMSAgain),"$it")
        }
    }

    private fun addFormattersToFields() {
        val phoneField = findViewById<EditText>(R.id.editText)
        phoneField.add(PhoneFormatter)

        val smsField = findViewById<EditText>(R.id.smsEditText)
        smsField.add(SMSFormatter)
    }

    private fun setSMSButton(title: String, subtitle: String) {
        val button = findViewById<Button>(R.id.confirmSMSButton)
        val font = ResourcesCompat.getFont(this, R.font.roboto_medium)
        val font2 =  ResourcesCompat.getFont(this, R.font.roboto_thin)
        val SS = SpannableStringBuilder("$title ($subtitle)")
        SS.setSpan(CustomTypefaceSpan("", font), 0, title.length, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
        SS.setSpan(CustomTypefaceSpan("", font2), title.length, SS.length, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
        button.text = SS
    }

}
