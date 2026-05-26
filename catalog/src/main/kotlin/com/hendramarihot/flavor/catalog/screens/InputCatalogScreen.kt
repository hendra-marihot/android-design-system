package com.hendramarihot.flavor.catalog.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
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
import com.hendramarihot.flavor.input.FlavorTextField
import com.hendramarihot.flavor.theme.Flavor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputCatalogScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var basicText by remember { mutableStateOf("") }
    var searchText by remember { mutableStateOf("") }
    var errorText by remember { mutableStateOf("invalid@") }
    var passwordText by remember { mutableStateOf("secret") }
    var multilineText by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Inputs") },
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
                    text = "Basic",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            item {
                FlavorTextField(
                    value = basicText,
                    onValueChange = { basicText = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = "Full Name",
                    placeholder = "Enter your name",
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
                FlavorTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = "Search",
                    placeholder = "Search for items...",
                    leadingIcon = Icons.Filled.Search,
                )
            }
            item {
                Text(
                    text = "Error State",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorTextField(
                    value = errorText,
                    onValueChange = { errorText = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = "Email",
                    isError = true,
                    errorMessage = "Please enter a valid email address",
                )
            }
            item {
                Text(
                    text = "With Trailing Icon",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorTextField(
                    value = passwordText,
                    onValueChange = { passwordText = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = "Password",
                    trailingIcon = Icons.Filled.Visibility,
                )
            }
            item {
                Text(
                    text = "Multiline",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorTextField(
                    value = multilineText,
                    onValueChange = { multilineText = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = "Bio",
                    placeholder = "Tell us about yourself...",
                    singleLine = false,
                    maxLines = 4,
                )
            }
            item {
                Text(
                    text = "Disabled",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = Flavor.tokens.spacingMd),
                )
            }
            item {
                FlavorTextField(
                    value = "Cannot edit this",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    label = "Read-only Field",
                    enabled = false,
                )
            }
        }
    }
}
