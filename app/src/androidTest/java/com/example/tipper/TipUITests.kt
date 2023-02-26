package com.example.tipper

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tipper.ui.theme.TipperTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat


//Instrumentation Test
class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipperTheme() {
                TipperScreen()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with this text was found.")
//        composeTestRule.onNodeWithText("Bill Amount")
//            .performTextInput("10")
//        composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
//        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
//        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
//            "No node with this text was found."
//        )
    }
}