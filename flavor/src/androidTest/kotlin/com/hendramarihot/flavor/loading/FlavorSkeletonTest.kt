package com.hendramarihot.flavor.loading

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.assertIsDisplayed
import com.hendramarihot.flavor.theme.FlavorTheme
import org.junit.Rule
import org.junit.Test

class FlavorSkeletonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun listItemSkeletonRendersWithoutCrash() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorListItemSkeleton()
            }
        }
        composeTestRule.onRoot().assertIsDisplayed()
    }

    @Test
    fun cardSkeletonRendersWithoutCrash() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorCardSkeleton()
            }
        }
        composeTestRule.onRoot().assertIsDisplayed()
    }
}
