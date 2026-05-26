package com.hendramarihot.flavor.dialog

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.hendramarihot.flavor.theme.FlavorTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class FlavorDialogTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun displaysTitle() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorDialog(
                    title = "Confirm Action",
                    message = "Are you sure?",
                    confirmText = "OK",
                    onConfirm = {},
                    onDismiss = {},
                )
            }
        }
        composeTestRule.onNodeWithText("Confirm Action").assertIsDisplayed()
    }

    @Test
    fun displaysMessage() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorDialog(
                    title = "Title",
                    message = "This is a message",
                    confirmText = "OK",
                    onConfirm = {},
                    onDismiss = {},
                )
            }
        }
        composeTestRule.onNodeWithText("This is a message").assertIsDisplayed()
    }

    @Test
    fun confirmButtonFiresCallback() {
        var confirmed = 0
        composeTestRule.setContent {
            FlavorTheme {
                FlavorDialog(
                    title = "Title",
                    message = "Message",
                    confirmText = "Confirm",
                    onConfirm = { confirmed++ },
                    onDismiss = {},
                )
            }
        }
        composeTestRule.onNodeWithText("Confirm").performClick()
        assertEquals(1, confirmed)
    }

    @Test
    fun dismissButtonFiresCallback() {
        var dismissed = 0
        composeTestRule.setContent {
            FlavorTheme {
                FlavorDialog(
                    title = "Title",
                    message = "Message",
                    confirmText = "OK",
                    onConfirm = {},
                    onDismiss = { dismissed++ },
                )
            }
        }
        composeTestRule.onNodeWithText("Cancel").performClick()
        assertEquals(1, dismissed)
    }

    @Test
    fun customDismissTextIsDisplayed() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorDialog(
                    title = "Title",
                    message = "Message",
                    confirmText = "OK",
                    onConfirm = {},
                    onDismiss = {},
                    dismissText = "Never mind",
                )
            }
        }
        composeTestRule.onNodeWithText("Never mind").assertIsDisplayed()
    }
}
