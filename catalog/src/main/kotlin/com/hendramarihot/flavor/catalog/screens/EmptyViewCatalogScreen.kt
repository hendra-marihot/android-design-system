package com.hendramarihot.flavor.catalog.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Inbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hendramarihot.flavor.state.FlavorEmptyView
import com.hendramarihot.flavor.theme.Flavor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmptyViewCatalogScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Empty Views") },
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
                    text = "With Description and CTA",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            item {
                FlavorEmptyView(
                    title = "No Items Yet",
                    description = "Your list is empty. Add your first item to get started.",
                    actionLabel = "Add Item",
                    onAction = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = Flavor.tokens.spacingLg),
                )
            }
            item {
                HorizontalDivider()
            }
            item {
                Text(
                    text = "Custom Icon Override",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorEmptyView(
                    title = "No Favorites",
                    description = "Items you favourite will appear here.",
                    icon = Icons.Outlined.FavoriteBorder,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = Flavor.tokens.spacingLg),
                )
            }
            item {
                HorizontalDivider()
            }
            item {
                Text(
                    text = "Default (No Description, No CTA)",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorEmptyView(
                    title = "Nothing to Show",
                    icon = Icons.Outlined.Inbox,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = Flavor.tokens.spacingLg),
                )
            }
        }
    }
}
