package com.hendramarihot.flavor.theme

import androidx.compose.ui.unit.dp
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class FlavorTokensTest {

    @Test
    fun `Default instance has expected spacing values`() {
        val tokens = FlavorTokens.Default
        assertEquals(4.dp, tokens.spacingXs)
        assertEquals(8.dp, tokens.spacingSm)
        assertEquals(16.dp, tokens.spacingMd)
        assertEquals(24.dp, tokens.spacingLg)
        assertEquals(32.dp, tokens.spacingXl)
    }

    @Test
    fun `Default instance has expected radius values`() {
        val tokens = FlavorTokens.Default
        assertEquals(8.dp, tokens.radiusSm)
        assertEquals(12.dp, tokens.radiusMd)
        assertEquals(16.dp, tokens.radiusLg)
        assertEquals(999.dp, tokens.radiusFull)
    }

    @Test
    fun `Default instance has expected elevation values`() {
        val tokens = FlavorTokens.Default
        assertEquals(0.dp, tokens.elevationNone)
        assertEquals(1.dp, tokens.elevationSm)
        assertEquals(3.dp, tokens.elevationMd)
        assertEquals(6.dp, tokens.elevationLg)
    }

    @Test
    fun `Default instance has expected icon size values`() {
        val tokens = FlavorTokens.Default
        assertEquals(16.dp, tokens.iconSizeSm)
        assertEquals(24.dp, tokens.iconSizeMd)
        assertEquals(32.dp, tokens.iconSizeLg)
    }

    @Test
    fun `Default instance has expected button and stroke tokens`() {
        val tokens = FlavorTokens.Default
        assertEquals(18.dp, tokens.iconSizeButton)
        assertEquals(2.dp, tokens.strokeWidthSm)
    }

    @Test
    fun `Default instance has expected shimmer height token`() {
        val tokens = FlavorTokens.Default
        assertEquals(20.dp, tokens.shimmerHeight)
    }

    @Test
    fun `custom tokens override specific values`() {
        val custom = FlavorTokens(spacingMd = 24.dp, radiusSm = 4.dp)
        assertEquals(24.dp, custom.spacingMd)
        assertEquals(4.dp, custom.radiusSm)
        assertEquals(8.dp, custom.spacingSm)
    }

    @Test
    fun `copy preserves unmodified values`() {
        val custom = FlavorTokens.Default.copy(spacingXl = 48.dp)
        assertEquals(48.dp, custom.spacingXl)
        assertEquals(FlavorTokens.Default.spacingMd, custom.spacingMd)
        assertEquals(FlavorTokens.Default.radiusSm, custom.radiusSm)
    }

    @Test
    fun `data class equality works correctly`() {
        assertEquals(FlavorTokens.Default, FlavorTokens())
        assertNotEquals(FlavorTokens.Default, FlavorTokens(spacingMd = 32.dp))
    }
}
