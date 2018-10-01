package com.example.hadevs.projectlocation

class PhoneInteractor {

}
object PhoneFormatter {
    fun format(phone: String): String {
        val re = Regex("[^A-Za-z0-9]")
        val formatted = re.replace(phone, "")

        return when(formatted.length) {
            0 -> "+7"
            1 -> "+$formatted"
            2 -> "+" + formatted[0] + "(" + formatted[1]
            3 -> "+" + formatted[0] + "(" + formatted.substring(1,3)
            4 -> "+" + formatted[0] + "(" + formatted.substring(1,4) + ")"
            5 -> "+" + formatted[0] + "(" + formatted.substring(1,4) + ")" + " " + formatted[4]
            6 -> "+" + formatted[0] + "(" + formatted.substring(1,4) + ")" + " " + formatted.substring(4,6)
            7 -> "+" + formatted[0] + "(" + formatted.substring(1,4) + ")" + " " + formatted.substring(4,7)
            8 -> "+" + formatted[0] + "(" + formatted.substring(1,4) + ")" + " " + formatted.substring(4,7) + " " + formatted[7]
            9 -> "+" + formatted[0] + "(" + formatted.substring(1,4) + ")" + " " + formatted.substring(4,7) + " " + formatted.substring(7,9)
            10 -> "+" + formatted[0] + "(" + formatted.substring(1,4) + ")" + " " + formatted.substring(4,7) + " " + formatted.substring(7,9) + " " + formatted[9]
            11 -> "+" + formatted[0] + "(" + formatted.substring(1,4) + ")" + " " + formatted.substring(4,7) + " " + formatted.substring(7,9) + " " + formatted.substring(9, 11)
            else -> format(formatted.substring(0,11))
        }
    }
}