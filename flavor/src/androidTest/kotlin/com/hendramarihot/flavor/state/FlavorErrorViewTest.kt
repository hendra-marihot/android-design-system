package com.hendramarihot.flavor.state

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.hendramarihot.flavor.theme.FlavorTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class FlavorErrorViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun displaysErrorMessage() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorErrorView(message = "Something went wrong")
            }
        }
        composeTestRule.onNodeWithText("Something went wrong").assertIsDisplayed()
    }

    @Test
    fun retryButtonVisibleWhenOnRetryProvided() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorErrorView(message = "Error", onRetry = {})
            }
        }
        composeTestRule.onNodeWithText("Retry").assertIsDisplayed()
    }

    @Test
    fun retryButtonHiddenWhenOnRetryNull() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorErrorView(message = "Error", onRetry = null)
            }
        }
        composeTestRule.onNodeWithText("Retry").assertDoesNotExist()
    }

    @Test
    fun retryButtonFiresCallback() {
        var retried = 0
        composeTestRule.setContent {
            FlavorTheme {
                FlavorErrorView(message = "Error", onRetry = { retried++ })
            }
        }
        composeTestRule.onNodeWithText("Retry").performClick()
        assertEquals(1, retried)
    }

    @Test
    fun customRetryTextIsDisplayed() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorErrorView(
                    message = "Error",
                    onRetry = {},
                    retryText = "Try Again",
                )
            }
        }
        composeTestRule.onNodeWithText("Try Again").assertIsDisplayed()
    }
}
