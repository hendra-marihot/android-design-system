package com.hendramarihot.flavor.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class FlavorTokens(
    val spacingXs: Dp = 4.dp,
    val spacingSm: Dp = 8.dp,
    val spacingMd: Dp = 16.dp,
    val spacingLg: Dp = 24.dp,
    val spacingXl: Dp = 32.dp,

    val radiusSm: Dp = 8.dp,
    val radiusMd: Dp = 12.dp,
    val radiusLg: Dp = 16.dp,
    val radiusFull: Dp = 999.dp,

    val elevationNone: Dp = 0.dp,
    val elevationSm: Dp = 1.dp,
    val elevationMd: Dp = 3.dp,
    val elevationLg: Dp = 6.dp,

    val iconSizeSm: Dp = 16.dp,
    val iconSizeMd: Dp = 24.dp,
    val iconSizeLg: Dp = 32.dp,
    val iconSizeButton: Dp = 18.dp,

    val strokeWidthSm: Dp = 2.dp,

    val shimmerHeight: Dp = 20.dp,

    val skeletonAvatarSize: Dp = 48.dp,
    val skeletonBlockHeight: Dp = 160.dp,
    val skeletonLineHeightMd: Dp = 16.dp,
    val skeletonLineHeightSm: Dp = 14.dp,
    val skeletonLineHeightXs: Dp = 12.dp,
) {
    companion object {
        val Default = FlavorTokens()
    }
}
