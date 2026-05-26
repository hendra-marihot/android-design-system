package com.hendramarihot.flavor.catalog.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Info
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
import com.hendramarihot.flavor.dialog.FlavorDialog
import com.hendramarihot.flavor.theme.Flavor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogCatalogScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var showStandardDialog by remember { mutableStateOf(false) }
    var showDestructiveDialog by remember { mutableStateOf(false) }
    var showIconDialog by remember { mutableStateOf(false) }

    if (showStandardDialog) {
        FlavorDialog(
            title = "Confirm Action",
            message = "Are you sure you want to proceed with this action?",
            confirmText = "Confirm",
            onConfirm = { showStandardDialog = false },
            onDismiss = { showStandardDialog = false },
        )
    }

    if (showDestructiveDialog) {
        FlavorDialog(
            title = "Delete Item",
            message = "This action cannot be undone. The item will be permanently removed.",
            confirmText = "Delete",
            onConfirm = { showDestructiveDialog = false },
            onDismiss = { showDestructiveDialog = false },
            isDestructive = true,
        )
    }

    if (showIconDialog) {
        FlavorDialog(
            title = "Information",
            message = "This dialog includes an icon at the top for additional visual context.",
            confirmText = "Got It",
            onConfirm = { showIconDialog = false },
            onDismiss = { showIconDialog = false },
            dismissText = "Dismiss",
            icon = Icons.Outlined.Info,
        )
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Dialogs") },
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
                    text = "Standard Dialog",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            item {
                FlavorButton(
                    text = "Show Standard Dialog",
                    onClick = { showStandardDialog = true },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            item {
                Text(
                    text = "Destructive Dialog",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorButton(
                    text = "Show Destructive Dialog",
                    onClick = { showDestructiveDialog = true },
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorButtonStyle.Destructive,
                    leadingIcon = Icons.Outlined.Delete,
                )
            }
            item {
                Text(
                    text = "Dialog with Icon",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorButton(
                    text = "Show Dialog with Icon",
                    onClick = { showIconDialog = true },
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorButtonStyle.Secondary,
                    leadingIcon = Icons.Outlined.Info,
                )
            }
        }
    }
}
