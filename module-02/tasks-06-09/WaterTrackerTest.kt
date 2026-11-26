package com.example.myapplication

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun waterButtonTest() {
        composeTestRule.setContent {
            MaterialTheme {
                WaterTracker()
            }
        }

        composeTestRule
            .onNodeWithText("+250 мл")
            .assertIsDisplayed()
            .performClick()
        composeTestRule
            .onNodeWithTag("Value_text")
            .assertIsDisplayed()
            .assertTextEquals("250 мл")

        composeTestRule
            .onNodeWithText("+250 мл")
            .performClick()
        composeTestRule
            .onNodeWithTag("Value_text")
            .assertTextEquals("500 мл")
    }

    @Test
    fun endDayButtonTest() {
        composeTestRule.setContent {
            MaterialTheme {
                WaterTracker()
            }
        }

        composeTestRule
            .onNodeWithText("+250 мл")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Завершить день")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag("Value_text")
            .assertIsDisplayed()
            .assertTextEquals("0 мл")
        composeTestRule
            .onNodeWithTag("Count_days_text")
            .assertIsDisplayed()
            .assertTextEquals("Количество дней: 0")

        val clicks = listOf(0, 5, 6, 10, 5, 7, 0)
        val expectedDays = listOf(0, 0, 1, 2, 0, 1, 0)
        for (day in clicks.indices) {
            for (i in 1..clicks[day]) {
                composeTestRule
                    .onNodeWithText("+250 мл")
                    .performClick()
            }

            composeTestRule
                .onNodeWithTag("Value_text")
                .assertTextEquals("${clicks[day] * 250} мл")

            val previousDays = if (day == 0) 0 else expectedDays[day - 1]

            composeTestRule
                .onNodeWithTag("Count_days_text")
                .assertTextEquals("Количество дней: $previousDays")

            composeTestRule
                .onNodeWithText("Завершить день")
                .performClick()

            composeTestRule
                .onNodeWithTag("Value_text")
                .assertTextEquals("0 мл")

            composeTestRule
                .onNodeWithTag("Count_days_text")
                .assertTextEquals("Количество дней: ${expectedDays[day]}")
        }
    }
}
