package com.hendramarihot.flavor.catalog.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.Modifier
import com.hendramarihot.flavor.card.FlavorCard
import com.hendramarihot.flavor.card.FlavorCardStyle
import com.hendramarihot.flavor.theme.Flavor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardCatalogScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Cards") },
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
            verticalArrangement = Arrangement.spacedBy(Flavor.tokens.spacingMd),
        ) {
            item {
                Text(
                    text = "Elevated",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            item {
                FlavorCard(
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorCardStyle.Elevated,
                ) {
                    Text(
                        text = "Elevated Card",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Text(
                        text = "Non-clickable variant with shadow elevation",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = Flavor.tokens.spacingXs),
                    )
                }
            }
            item {
                FlavorCard(
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorCardStyle.Elevated,
                    onClick = {},
                ) {
                    Text(
                        text = "Elevated Card (Clickable)",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Text(
                        text = "Tap me — elevated style with ripple",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = Flavor.tokens.spacingXs),
                    )
                }
            }
            item {
                Text(
                    text = "Filled",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorCard(
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorCardStyle.Filled,
                ) {
                    Text(
                        text = "Filled Card",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Text(
                        text = "Non-clickable variant with surface variant background",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = Flavor.tokens.spacingXs),
                    )
                }
            }
            item {
                FlavorCard(
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorCardStyle.Filled,
                    onClick = {},
                ) {
                    Text(
                        text = "Filled Card (Clickable)",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Text(
                        text = "Tap me — filled style with ripple",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = Flavor.tokens.spacingXs),
                    )
                }
            }
            item {
                Text(
                    text = "Outlined",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorCard(
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorCardStyle.Outlined,
                ) {
                    Text(
                        text = "Outlined Card",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Text(
                        text = "Non-clickable variant with border stroke",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = Flavor.tokens.spacingXs),
                    )
                }
            }
            item {
                FlavorCard(
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorCardStyle.Outlined,
                    onClick = {},
                ) {
                    Text(
                        text = "Outlined Card (Clickable)",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Text(
                        text = "Tap me — outlined style with ripple",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = Flavor.tokens.spacingXs),
                    )
                }
            }
        }
    }
}
