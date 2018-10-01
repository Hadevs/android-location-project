package com.example.hadevs.projectlocation

import org.junit.Test
import org.junit.Assert.*

class PhoneFormatterUnitTest {
    @Test
    fun test_phone_without_prefix_1() {
        val phone = "9(18) 167-28-10"
        assertEquals("+7(918) 167 28 10", PhoneFormatter.format(phone))
    }
    @Test
    fun test_phone_without_prefix_2() {
        val phone = "9(18) 167-fasdhnjkasdfjkhasdfhjk28 kfdhlfdsfdsahlkfda10"
        assertEquals("+7(918) 167 28 10", PhoneFormatter.format(phone))
    }
    @Test
    fun test_phone_without_prefix_3() {
        val phone = "9gffgd18) 167-28-10"
        assertEquals("+7(918) 167 28 10", PhoneFormatter.format(phone))
    }
    @Test
    fun test_phone_without_prefix_4() {
        val phone = "9((((18) 167-28-10"
        assertEquals("+7(918) 167 28 10", PhoneFormatter.format(phone))
    }

    @Test
    fun test_phone_with_prefix_1() {
        val phone = "+79(18sdfgsdfg) 167-28-10"
        assertEquals("+7(918) 167 28 10", PhoneFormatter.format(phone))
    }
    @Test
    fun test_phone_with_prefix_2() {
        val phone = "+7 9(18) 167-28-10"
        assertEquals("+7(918) 167 28 10", PhoneFormatter.format(phone))
    }
    @Test
    fun test_phone_with_prefix_3() {
        val phone = "79(18) 167-28-10"
        assertEquals("+7(918) 167 28 10", PhoneFormatter.format(phone))
    }
    @Test
    fun test_phone_with_prefix_4() {
        val phone = "+77(18) 167-28-10"
        assertEquals("+7(718) 167 28 10", PhoneFormatter.format(phone))
    }

    @Test
    fun test_phone_with_prefix_5() {
        val phone = "+79(18) 167-28-10"
        assertEquals("+7(918) 167 28 10", PhoneFormatter.format(phone))
    }
}
