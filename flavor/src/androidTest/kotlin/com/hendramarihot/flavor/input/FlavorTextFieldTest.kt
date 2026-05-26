package com.hendramarihot.flavor.input

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.hendramarihot.flavor.theme.FlavorTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class FlavorTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rendersLabel() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorTextField(
                    value = "",
                    onValueChange = {},
                    label = "Email",
                )
            }
        }
        composeTestRule.onNodeWithText("Email").assertIsDisplayed()
    }

    @Test
    fun valueUpdatesOnInput() {
        var text by mutableStateOf("")
        composeTestRule.setContent {
            FlavorTheme {
                FlavorTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = "Name",
                )
            }
        }
        composeTestRule.onNodeWithText("Name").performTextInput("Hello")
        assertEquals("Hello", text)
    }

    @Test
    fun errorMessageAppearsWhenIsError() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorTextField(
                    value = "bad",
                    onValueChange = {},
                    isError = true,
                    errorMessage = "Invalid input",
                )
            }
        }
        composeTestRule.onNodeWithText("Invalid input").assertIsDisplayed()
    }

    @Test
    fun errorMessageHiddenWhenNotError() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorTextField(
                    value = "good",
                    onValueChange = {},
                    isError = false,
                    errorMessage = "Should not show",
                )
            }
        }
        composeTestRule.onNodeWithText("Should not show").assertDoesNotExist()
    }

    @Test
    fun placeholderShownWhenEmpty() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = "Type here...",
                )
            }
        }
        composeTestRule.onNodeWithText("Type here...").assertIsDisplayed()
    }
}
