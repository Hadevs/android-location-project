package com.example.hadevs.projectlocation.Extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.example.hadevs.projectlocation.Interactors.StringFormatter

fun EditText.add(formatter: StringFormatter) {
    onTextChanged {
        val text = formatter.format(this.text.toString())
        this.setText(text)
        this.setSelection(text.length)
    }
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

fun EditText.onTextChanged(afterTextChanged: () -> Unit) {
    var lock = false
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if (lock) {
                return
            }

            lock = true
            afterTextChanged.invoke()
            lock = false
        }

        override fun afterTextChanged(editable: Editable?) {
        }
    })
}