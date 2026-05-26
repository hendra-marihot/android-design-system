package com.hendramarihot.flavor.catalog.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hendramarihot.flavor.theme.Flavor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeCatalogScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val tokens = Flavor.tokens

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Theme Tokens") },
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Navigate up")
                    }
                },
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(Flavor.tokens.spacingMd),
            verticalArrangement = Arrangement.spacedBy(Flavor.tokens.spacingSm),
        ) {
            item {
                Text(
                    text = "Spacing Scale",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            item { SpacingTokenRow(name = "spacingXs", value = tokens.spacingXs) }
            item { SpacingTokenRow(name = "spacingSm", value = tokens.spacingSm) }
            item { SpacingTokenRow(name = "spacingMd", value = tokens.spacingMd) }
            item { SpacingTokenRow(name = "spacingLg", value = tokens.spacingLg) }
            item { SpacingTokenRow(name = "spacingXl", value = tokens.spacingXl) }

            item {
                Text(
                    text = "Radius Scale",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item { RadiusTokenRow(name = "radiusSm", value = tokens.radiusSm) }
            item { RadiusTokenRow(name = "radiusMd", value = tokens.radiusMd) }
            item { RadiusTokenRow(name = "radiusLg", value = tokens.radiusLg) }
            item { RadiusTokenRow(name = "radiusFull", value = tokens.radiusFull) }

            item {
                Text(
                    text = "Elevation Scale",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item { ElevationTokenRow(name = "elevationNone", value = tokens.elevationNone) }
            item { ElevationTokenRow(name = "elevationSm", value = tokens.elevationSm) }
            item { ElevationTokenRow(name = "elevationMd", value = tokens.elevationMd) }
            item { ElevationTokenRow(name = "elevationLg", value = tokens.elevationLg) }

            item {
                Text(
                    text = "Icon Sizes",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item { IconSizeTokenRow(name = "iconSizeSm", value = tokens.iconSizeSm) }
            item { IconSizeTokenRow(name = "iconSizeMd", value = tokens.iconSizeMd) }
            item { IconSizeTokenRow(name = "iconSizeLg", value = tokens.iconSizeLg) }
        }
    }
}

@Composable
private fun SpacingTokenRow(
    name: String,
    value: Dp,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Flavor.tokens.spacingXs),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Flavor.tokens.spacingMd),
    ) {
        Box(
            modifier = Modifier
                .size(width = value, height = Flavor.tokens.spacingMd)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(Flavor.tokens.radiusSm),
                ),
        )
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f),
        )
        Text(
            text = "${value.value.toInt()}dp",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Composable
private fun RadiusTokenRow(
    name: String,
    value: Dp,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Flavor.tokens.spacingXs),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Flavor.tokens.spacingMd),
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(value))
                .background(MaterialTheme.colorScheme.secondaryContainer),
        )
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f),
        )
        Text(
            text = "${value.value.toInt()}dp",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Composable
private fun ElevationTokenRow(
    name: String,
    value: Dp,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Flavor.tokens.spacingXs),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Flavor.tokens.spacingMd),
    ) {
        Box(
            modifier = Modifier
                .size(width = 80.dp, height = 32.dp)
                .shadow(elevation = value, shape = RoundedCornerShape(Flavor.tokens.radiusSm))
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(Flavor.tokens.radiusSm),
                ),
        )
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f),
        )
        Text(
            text = "${value.value.toInt()}dp",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Composable
private fun IconSizeTokenRow(
    name: String,
    value: Dp,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Flavor.tokens.spacingXs),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Flavor.tokens.spacingMd),
    ) {
        Box(
            modifier = Modifier
                .size(value)
                .background(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = RoundedCornerShape(Flavor.tokens.radiusSm),
                ),
        )
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f),
        )
        Text(
            text = "${value.value.toInt()}dp",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
