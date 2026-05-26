package com.hendramarihot.flavor.loading

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.test.assertHeightIsAtLeast
import androidx.compose.ui.test.assertWidthIsAtLeast
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.unit.dp
import com.hendramarihot.flavor.theme.FlavorTheme
import org.junit.Rule
import org.junit.Test

class FlavorShimmerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun respectsExternalSizeConstraints() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorShimmer(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    height = 48.dp,
                )
            }
        }
        composeTestRule.onRoot().assertWidthIsAtLeast(40.dp)
    }

    @Test
    fun rendersWithFillMaxWidth() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorShimmer(modifier = Modifier.fillMaxWidth())
            }
        }
        composeTestRule.onRoot().assertHeightIsAtLeast(16.dp)
        composeTestRule.onRoot().assertWidthIsAtLeast(1.dp)
    }

    @Test
    fun rendersWithCustomHeight() {
        composeTestRule.setContent {
            FlavorTheme {
                FlavorShimmer(modifier = Modifier.fillMaxWidth(), height = 100.dp)
            }
        }
        composeTestRule.onRoot().assertHeightIsAtLeast(96.dp)
    }
}
