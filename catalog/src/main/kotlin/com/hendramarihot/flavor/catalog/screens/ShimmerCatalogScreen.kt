package com.hendramarihot.flavor.catalog.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hendramarihot.flavor.loading.FlavorShimmer
import com.hendramarihot.flavor.theme.Flavor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShimmerCatalogScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Shimmer") },
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
                    text = "Full Width",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            item {
                FlavorShimmer(
                    modifier = Modifier.fillMaxWidth(),
                    height = 20.dp,
                )
            }
            item {
                FlavorShimmer(
                    modifier = Modifier.fillMaxWidth(),
                    height = 48.dp,
                )
            }
            item {
                Text(
                    text = "Half Width",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorShimmer(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    height = 16.dp,
                )
            }
            item {
                FlavorShimmer(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    height = 32.dp,
                )
            }
            item {
                Text(
                    text = "Circle (Avatar Placeholder)",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorShimmer(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    height = 40.dp,
                )
            }
            item {
                FlavorShimmer(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape),
                    height = 56.dp,
                )
            }
            item {
                Text(
                    text = "Tall Block (Image Placeholder)",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorShimmer(
                    modifier = Modifier.fillMaxWidth(),
                    height = 160.dp,
                )
            }
        }
    }
}
