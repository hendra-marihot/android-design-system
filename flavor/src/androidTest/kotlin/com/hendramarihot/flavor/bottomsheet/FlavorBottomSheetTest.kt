package com.hendramarihot.flavor.bottomsheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.hendramarihot.flavor.theme.FlavorTheme
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalMaterial3Api::class)
class FlavorBottomSheetTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun titleIsShownWhenProvided() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorBottomSheet(
                    onDismiss = {},
                    title = "Sheet Title",
                ) {
                    Text("Content")
                }
            }
        }
        composeTestRule.onNodeWithText("Sheet Title").assertIsDisplayed()
    }

    @Test
    fun titleIsHiddenWhenNull() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorBottomSheet(
                    onDismiss = {},
                    title = null,
                ) {
                    Text("Content only")
                }
            }
        }
        composeTestRule.onNodeWithText("Sheet Title").assertDoesNotExist()
        composeTestRule.onNodeWithText("Content only").assertIsDisplayed()
    }

    @Test
    fun contentIsDisplayed() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorBottomSheet(
                    onDismiss = {},
                    title = "Title",
                ) {
                    Text("Sheet body content")
                }
            }
        }
        composeTestRule.onNodeWithText("Sheet body content").assertIsDisplayed()
    }
}
