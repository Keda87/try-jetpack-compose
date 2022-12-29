package com.example.tipcalculator

import junit.framework.TestCase.assertEquals
import org.junit.Test

class TipCalculatorTests {

    @Test
    fun calculate_20_percent_no_round() {
        val amount = 10.00
        val tipPercentage = 20.00
        val expectedTip = "$2.00"
        val actualTip = calculateTip(amount, tipPercentage, false)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculate_32_point_3_percent_with_round() {
        val amount = 10.00
        val tipPercentage = 32.3
        val expectedTip = "$4.00"
        val actualTip = calculateTip(amount, tipPercentage, true)
        assertEquals(expectedTip, actualTip)
    }

}