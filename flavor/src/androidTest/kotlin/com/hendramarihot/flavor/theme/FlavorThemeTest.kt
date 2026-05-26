package com.hendramarihot.flavor.theme

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class FlavorThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun defaultTokensAreProvided() {
        var tokens: FlavorTokens? = null
        composeTestRule.setContent {
            FlavorTheme {
                tokens = Flavor.tokens
            }
        }
        assertEquals(FlavorTokens.Default, tokens)
    }

    @Test
    fun customTokensAreProvided() {
        val custom = FlavorTokens(spacingMd = 24.dp)
        var tokens: FlavorTokens? = null
        composeTestRule.setContent {
            FlavorTheme(tokens = custom) {
                tokens = Flavor.tokens
            }
        }
        assertEquals(24.dp, tokens?.spacingMd)
    }
}
