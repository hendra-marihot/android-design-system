package com.hendramarihot.flavor.state

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.hendramarihot.flavor.theme.FlavorTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class FlavorEmptyViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun displaysTitleText() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorEmptyView(title = "No items")
            }
        }
        composeTestRule.onNodeWithText("No items").assertIsDisplayed()
    }

    @Test
    fun displaysDescription() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorEmptyView(title = "Empty", description = "Nothing here yet")
            }
        }
        composeTestRule.onNodeWithText("Nothing here yet").assertIsDisplayed()
    }

    @Test
    fun actionButtonVisibleWhenBothLabelAndCallbackProvided() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorEmptyView(
                    title = "Empty",
                    actionLabel = "Add Item",
                    onAction = {},
                )
            }
        }
        composeTestRule.onNodeWithText("Add Item").assertIsDisplayed()
    }

    @Test
    fun actionButtonHiddenWhenLabelNull() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorEmptyView(
                    title = "Empty",
                    actionLabel = null,
                    onAction = {},
                )
            }
        }
        composeTestRule.onNodeWithText("Add Item").assertDoesNotExist()
    }

    @Test
    fun actionButtonHiddenWhenCallbackNull() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorEmptyView(
                    title = "Empty",
                    actionLabel = "Add Item",
                    onAction = null,
                )
            }
        }
        composeTestRule.onNodeWithText("Add Item").assertDoesNotExist()
    }

    @Test
    fun actionButtonFiresCallback() {
        var actionCount = 0
        composeTestRule.setContent {
            FlavorTheme {
                FlavorEmptyView(
                    title = "Empty",
                    actionLabel = "Create",
                    onAction = { actionCount++ },
                )
            }
        }
        composeTestRule.onNodeWithText("Create").performClick()
        assertEquals(1, actionCount)
    }
}
