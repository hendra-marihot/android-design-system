package com.hendramarihot.flavor.loading

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hendramarihot.flavor.theme.Flavor
import com.hendramarihot.flavor.theme.FlavorTheme

@Composable
fun FlavorListItemSkeleton(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        FlavorShimmer(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            height = 48.dp,
        )
        Spacer(modifier = Modifier.width(Flavor.tokens.spacingMd))
        Column(
            verticalArrangement = Arrangement.spacedBy(Flavor.tokens.spacingSm),
            modifier = Modifier.weight(1f),
        ) {
            FlavorShimmer(
                modifier = Modifier.fillMaxWidth(0.7f),
                height = 16.dp,
            )
            FlavorShimmer(
                modifier = Modifier.fillMaxWidth(0.5f),
                height = 12.dp,
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun FlavorListItemSkeletonPreview() {
    FlavorTheme {
        FlavorListItemSkeleton(modifier = Modifier.padding(Flavor.tokens.spacingMd))
    }
}
