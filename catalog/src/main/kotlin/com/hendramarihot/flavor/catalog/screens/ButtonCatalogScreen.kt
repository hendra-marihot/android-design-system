package com.hendramarihot.flavor.catalog.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
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
import com.hendramarihot.flavor.button.FlavorButton
import com.hendramarihot.flavor.button.FlavorButtonStyle
import com.hendramarihot.flavor.theme.Flavor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonCatalogScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isLoading by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Buttons") },
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
                    text = "Button Variants",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            item {
                FlavorButton(
                    text = "Primary Button",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorButtonStyle.Primary,
                )
            }
            item {
                FlavorButton(
                    text = "Secondary Button",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorButtonStyle.Secondary,
                )
            }
            item {
                FlavorButton(
                    text = "Outline Button",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorButtonStyle.Outline,
                )
            }
            item {
                FlavorButton(
                    text = "Text Button",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorButtonStyle.Text,
                )
            }
            item {
                FlavorButton(
                    text = "Destructive Button",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorButtonStyle.Destructive,
                )
            }
            item {
                Text(
                    text = "With Leading Icon",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorButton(
                    text = "Add Item",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = Icons.Filled.Add,
                )
            }
            item {
                Text(
                    text = "Loading State",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorButton(
                    text = if (isLoading) "Loading..." else "Toggle Loading",
                    onClick = { isLoading = !isLoading },
                    modifier = Modifier.fillMaxWidth(),
                    loading = isLoading,
                )
            }
            item {
                Text(
                    text = "Disabled State",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorButton(
                    text = "Disabled Button",
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    enabled = false,
                )
            }
        }
    }
}
