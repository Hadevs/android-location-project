package com.example.hadevs.projectlocation.Formatters

object SMSFormatter: StringFormatter {
    override fun format(value: String): String {
        val re = Regex("[^0-9]")
        val formatted = re.replace(value, "")
        val endIndex = if (value.length >= 4) 4 else value.length
        return formatted.substring(0,endIndex)
    }
}