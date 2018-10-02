package com.example.hadevs.projectlocation.Interactors

import java.util.*
import kotlin.concurrent.schedule

class TimerInteractor(private val timeStep: Long, secondToLeft: Long = timeStep) {
    private var secondsLeft = secondToLeft
    private var isNeedToStop = false
    private var stepTime = timeStep * 1000
    var stopWhenEnd = false

    fun loop(closure: ((Long) -> Unit)? = null) {
        if (isNeedToStop) { return }

        closure?.invoke(secondsLeft)
        secondsLeft -= stepTime / 1000
        if (secondsLeft <= 0L && stopWhenEnd) {
            stop()
        }
        Timer().schedule(stepTime){
            loop(closure)
        }
    }

    fun stop() {
        isNeedToStop = true
    }
}