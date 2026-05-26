package com.hendramarihot.flavor.card

import androidx.compose.material3.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.hendramarihot.flavor.theme.FlavorTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class FlavorCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rendersContent() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorCard {
                    Text("Card Content")
                }
            }
        }
        composeTestRule.onNodeWithText("Card Content").assertIsDisplayed()
    }

    @Test
    fun clickableCardFiresCallback() {
        var clicked = 0
        composeTestRule.setContent {
            FlavorTheme {
                FlavorCard(onClick = { clicked++ }) {
                    Text("Clickable Card")
                }
            }
        }
        composeTestRule.onNodeWithText("Clickable Card").performClick()
        assertEquals(1, clicked)
    }

    @Test
    fun nonClickableCardHasNoClickSemantics() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorCard(onClick = null) {
                    Text("Static Card")
                }
            }
        }
        composeTestRule.onNode(hasClickAction()).assertDoesNotExist()
    }

    @Test
    fun allStylesRender() {
        FlavorCardStyle.entries.forEach { style ->
            composeTestRule.setContent {
                FlavorTheme {
                    FlavorCard(style = style) {
                        Text("${style.name} Card")
                    }
                }
            }
            composeTestRule.onNodeWithText("${style.name} Card").assertIsDisplayed()
        }
    }

    @Test
    fun clickableCardAllStyles() {
        FlavorCardStyle.entries.forEach { style ->
            var clicked = 0
            composeTestRule.setContent {
                FlavorTheme {
                    FlavorCard(style = style, onClick = { clicked++ }) {
                        Text("Click ${style.name}")
                    }
                }
            }
            composeTestRule.onNodeWithText("Click ${style.name}").performClick()
            assertEquals(1, clicked)
        }
    }
}
