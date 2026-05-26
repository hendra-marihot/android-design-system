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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hendramarihot.flavor.bottomsheet.FlavorBottomSheet
import com.hendramarihot.flavor.button.FlavorButton
import com.hendramarihot.flavor.button.FlavorButtonStyle
import com.hendramarihot.flavor.theme.Flavor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetCatalogScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var showSheetWithTitle by remember { mutableStateOf(false) }
    var showSheetWithoutTitle by remember { mutableStateOf(false) }

    if (showSheetWithTitle) {
        FlavorBottomSheet(
            onDismiss = { showSheetWithTitle = false },
            title = "Sheet Options",
        ) {
            Text(
                text = "Option A",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Flavor.tokens.spacingMd, vertical = Flavor.tokens.spacingSm),
            )
            Text(
                text = "Option B",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Flavor.tokens.spacingMd, vertical = Flavor.tokens.spacingSm),
            )
            Text(
                text = "Option C",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = Flavor.tokens.spacingMd,
                        vertical = Flavor.tokens.spacingSm,
                    )
                    .padding(bottom = Flavor.tokens.spacingMd),
            )
        }
    }

    if (showSheetWithoutTitle) {
        FlavorBottomSheet(
            onDismiss = { showSheetWithoutTitle = false },
        ) {
            Text(
                text = "This bottom sheet has no title.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Flavor.tokens.spacingMd),
            )
            FlavorButton(
                text = "Close",
                onClick = { showSheetWithoutTitle = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Flavor.tokens.spacingMd)
                    .padding(bottom = Flavor.tokens.spacingMd),
                style = FlavorButtonStyle.Secondary,
            )
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Bottom Sheets") },
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
                    text = "With Title",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            item {
                FlavorButton(
                    text = "Show Sheet with Title",
                    onClick = { showSheetWithTitle = true },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            item {
                Text(
                    text = "Without Title",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorButton(
                    text = "Show Sheet without Title",
                    onClick = { showSheetWithoutTitle = true },
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorButtonStyle.Secondary,
                )
            }
        }
    }
}
