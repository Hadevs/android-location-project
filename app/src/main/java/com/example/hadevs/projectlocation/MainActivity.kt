package com.example.hadevs.projectlocation

import android.app.ActionBar
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.DialogTitle
import android.view.Gravity
import android.widget.RelativeLayout
import android.widget.TextView
import android.graphics.Typeface
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBarWith(resources.getString(R.string.agent_screen_title));
        val tx = findViewById<TextView>(R.id.textView)
        val custom_font = Typeface.createFromAsset(assets, "font/Roboto-Medium.ttf")
        tx.setTypeface(custom_font)
    }

    private fun setActionBarWith(title: String) {
        val ab = supportActionBar
        ab?.elevation = 0F
        val tv = TextView(applicationContext)
        val lp = RelativeLayout.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT, // Width of TextView
                ActionBar.LayoutParams.WRAP_CONTENT) // Height of TextView
        ab?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.lightGray)))
        tv.layoutParams = lp
        tv.text = title
        tv.textSize = 16.0F
        tv.setTextColor(resources.getColor(R.color.lightBlue))
        tv.gravity = Gravity.CENTER
        ab?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        ab?.customView = tv
    }

}