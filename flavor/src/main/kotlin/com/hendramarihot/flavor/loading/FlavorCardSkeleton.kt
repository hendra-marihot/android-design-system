package com.hendramarihot.flavor.loading

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hendramarihot.flavor.theme.Flavor
import com.hendramarihot.flavor.theme.FlavorTheme

@Composable
fun FlavorCardSkeleton(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Flavor.tokens.spacingSm),
    ) {
        FlavorShimmer(modifier = Modifier.fillMaxWidth(), height = Flavor.tokens.skeletonBlockHeight)
        FlavorShimmer(modifier = Modifier.fillMaxWidth(0.8f), height = Flavor.tokens.shimmerHeight)
        FlavorShimmer(modifier = Modifier.fillMaxWidth(0.6f), height = Flavor.tokens.skeletonLineHeightSm)
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun FlavorCardSkeletonPreview() {
    FlavorTheme {
        FlavorCardSkeleton(modifier = Modifier.padding(Flavor.tokens.spacingMd))
    }
}
