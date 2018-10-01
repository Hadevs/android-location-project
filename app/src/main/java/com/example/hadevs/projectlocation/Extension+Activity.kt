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

fun Activity.animateElements(views: ArrayList<View>, duration: Long = 100, position: Position, closure: () -> Unit = {}) {
    val windowWidth = window.windowManager.defaultDisplay.width.toFloat()
    val windowHeight = window.windowManager.defaultDisplay.height.toFloat()
    fun calculateValueBy(view: View): Float {
        return when(position) {
            Position.DOWN -> windowHeight
            Position.LEFT -> -windowWidth
            Position.RIGHT -> windowWidth
            Position.UP -> -windowHeight
            Position.CENTER_X -> windowWidth / 2
            Position.CENTER_Y -> windowHeight / 2 - view.height / 2
        }
    }


    val dispatchGroup = DispatchGroup()
    for (view in views) {
        val k = calculateValueBy(view)
        val width = view.width

        val valueAnimator = ValueAnimator.ofFloat(0f, k - view.width)

        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            if (position == Position.UP || position == Position.DOWN || position == Position.CENTER_Y) {
                view.translationY = value
            } else {
                view.translationX = value
            }
        }
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.duration = duration
        dispatchGroup.enter()
        valueAnimator.start()
        valueAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                dispatchGroup.leave()
            }
        })
    }
    val callback = Runnable(closure)
    dispatchGroup.notify(callback)
}

fun Activity.animate(ids: ArrayList<Int>, duration: Long = 100, position: Position, closure: () -> Unit = {}) {
    animateElements(ids.map { this.findViewById<View>(it) } as ArrayList<View>, duration, position, closure)
}

enum class Position {
    UP, DOWN, LEFT, RIGHT, CENTER_X, CENTER_Y
}