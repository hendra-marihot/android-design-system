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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hendramarihot.flavor.state.FlavorErrorView
import com.hendramarihot.flavor.theme.Flavor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorViewCatalogScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Error Views") },
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
                    text = "With Retry",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            item {
                FlavorErrorView(
                    message = "Something went wrong while loading your data.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = Flavor.tokens.spacingLg),
                    onRetry = {},
                    retryText = "Try Again",
                )
            }
            item {
                HorizontalDivider()
            }
            item {
                Text(
                    text = "Without Retry",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorErrorView(
                    message = "An unexpected error occurred. Please contact support.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = Flavor.tokens.spacingLg),
                )
            }
        }
    }
}
