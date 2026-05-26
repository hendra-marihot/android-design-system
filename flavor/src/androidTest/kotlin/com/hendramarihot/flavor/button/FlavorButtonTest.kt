package com.hendramarihot.flavor.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.hendramarihot.flavor.theme.FlavorTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class FlavorButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rendersText() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorButton(text = "Click Me", onClick = {})
            }
        }
        composeTestRule.onNodeWithText("Click Me").assertIsDisplayed()
    }

    @Test
    fun clickFiresCallback() {
        var clicked = 0
        composeTestRule.setContent {
            FlavorTheme {
                FlavorButton(text = "Press", onClick = { clicked++ })
            }
        }
        composeTestRule.onNodeWithText("Press").performClick()
        assertEquals(1, clicked)
    }

    @Test
    fun loadingDisablesClick() {
        var clicked = 0
        composeTestRule.setContent {
            FlavorTheme {
                FlavorButton(text = "Loading", onClick = { clicked++ }, loading = true)
            }
        }
        composeTestRule.onNodeWithText("Loading").assertIsNotEnabled()
        composeTestRule.onNodeWithText("Loading").performClick()
        assertEquals(0, clicked)
    }

    @Test
    fun disabledButtonIsNotEnabled() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorButton(text = "Disabled", onClick = {}, enabled = false)
            }
        }
        composeTestRule.onNodeWithText("Disabled").assertIsNotEnabled()
    }

    @Test
    fun enabledButtonIsEnabled() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorButton(text = "Enabled", onClick = {}, enabled = true)
            }
        }
        composeTestRule.onNodeWithText("Enabled").assertIsEnabled()
    }

    @Test
    fun loadingWithIconShowsOnlySpinner() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorButton(
                    text = "Save",
                    onClick = {},
                    loading = true,
                    leadingIcon = Icons.Filled.Add,
                )
            }
        }
        composeTestRule.onNodeWithText("Save").assertIsDisplayed()
        composeTestRule.onNodeWithText("Save").assertIsNotEnabled()
    }

    @Test
    fun allStylesRender() {
        FlavorButtonStyle.entries.forEach { style ->
            composeTestRule.setContent {
                FlavorTheme {
                    FlavorButton(text = style.name, onClick = {}, style = style)
                }
            }
            composeTestRule.onNodeWithText(style.name).assertIsDisplayed()
        }
    }
}
