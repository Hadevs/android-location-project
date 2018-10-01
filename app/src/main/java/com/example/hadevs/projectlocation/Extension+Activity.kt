package com.example.hadevs.projectlocation

import android.animation.ValueAnimator
import android.app.Activity
import android.view.View
import android.view.animation.LinearInterpolator
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.ActionBar
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.Gravity
import android.widget.RelativeLayout
import android.widget.TextView

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.setActionBarWith(actionBar: android.support.v7.app.ActionBar?, title: String) {
    actionBar?.elevation = 0F
    val tv = TextView(applicationContext)
    val lp = RelativeLayout.LayoutParams(
            ActionBar.LayoutParams.MATCH_PARENT, // Width of TextView
            ActionBar.LayoutParams.WRAP_CONTENT) // Height of TextView
    actionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.lightGray)))
    tv.layoutParams = lp
    tv.text = title
    tv.textSize = 16.0F
    tv.setTextColor(resources.getColor(R.color.lightBlue))
    tv.gravity = Gravity.CENTER
    actionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
    actionBar?.customView = tv
}

fun Activity.animateElements(views: ArrayList<View>, direction: Direction, closure: () -> Unit = {}) {
    val windowWidth = window.windowManager.defaultDisplay.width.toFloat()
    val windowHeight = window.windowManager.defaultDisplay.height.toFloat()
    val toValue: Float = when(direction) {
        Direction.DOWN -> windowHeight
        Direction.LEFT -> -windowWidth
        Direction.RIGHT -> windowWidth
        Direction.UP -> -windowHeight
    }

    val valueAnimator = ValueAnimator.ofFloat(0f, toValue)

    valueAnimator.addUpdateListener {
        val value = it.animatedValue as Float
        for (view in views) {
            if (direction == Direction.UP || direction == Direction.DOWN) {
                view.translationY = value
            } else {
                view.translationX = value
            }
        }
    }

    valueAnimator.interpolator = LinearInterpolator()
    valueAnimator.duration = 100

    valueAnimator.start()
    valueAnimator.addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            closure()
        }
    })
}

fun Activity.animate(ids: ArrayList<Int>, direction: Direction, closure: () -> Unit = {}) {
    animateElements(ids.map { this.findViewById<View>(it) } as ArrayList<View>, direction, closure)
}

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}