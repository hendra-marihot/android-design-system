package com.hendramarihot.flavor.catalog.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hendramarihot.flavor.card.FlavorCard
import com.hendramarihot.flavor.card.FlavorCardStyle
import com.hendramarihot.flavor.theme.Flavor

private data class CatalogCategory(
    val title: String,
    val description: String,
    val onClick: () -> Unit,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogHomeScreen(
    onNavigateToButtons: () -> Unit,
    onNavigateToInputs: () -> Unit,
    onNavigateToCards: () -> Unit,
    onNavigateToShimmer: () -> Unit,
    onNavigateToSkeleton: () -> Unit,
    onNavigateToDialog: () -> Unit,
    onNavigateToBottomSheet: () -> Unit,
    onNavigateToErrorView: () -> Unit,
    onNavigateToEmptyView: () -> Unit,
    onNavigateToTheme: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val categories = listOf(
        CatalogCategory(
            title = "Buttons",
            description = "Primary, Secondary, Outline, Text, and Destructive variants with loading states",
            onClick = onNavigateToButtons,
        ),
        CatalogCategory(
            title = "Inputs",
            description = "Text fields with labels, placeholders, icons, and error states",
            onClick = onNavigateToInputs,
        ),
        CatalogCategory(
            title = "Cards",
            description = "Elevated, Filled, and Outlined variants; clickable and non-clickable",
            onClick = onNavigateToCards,
        ),
        CatalogCategory(
            title = "Shimmer",
            description = "Animated loading placeholder at various widths, heights, and shapes",
            onClick = onNavigateToShimmer,
        ),
        CatalogCategory(
            title = "Skeletons",
            description = "List item and card skeleton layouts for loading states",
            onClick = onNavigateToSkeleton,
        ),
        CatalogCategory(
            title = "Dialogs",
            description = "Standard and destructive alert dialogs with optional icon",
            onClick = onNavigateToDialog,
        ),
        CatalogCategory(
            title = "Bottom Sheets",
            description = "Modal bottom sheets with and without a title header",
            onClick = onNavigateToBottomSheet,
        ),
        CatalogCategory(
            title = "Error Views",
            description = "Full-page error state with optional retry action",
            onClick = onNavigateToErrorView,
        ),
        CatalogCategory(
            title = "Empty Views",
            description = "Empty state with description, CTA, and custom icon support",
            onClick = onNavigateToEmptyView,
        ),
        CatalogCategory(
            title = "Theme Tokens",
            description = "Spacing, radius, elevation, and icon size token values",
            onClick = onNavigateToTheme,
        ),
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(title = { Text("Flavor Design System") })
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(Flavor.tokens.spacingMd),
            verticalArrangement = Arrangement.spacedBy(Flavor.tokens.spacingMd),
        ) {
            items(
                count = categories.size,
                key = { index -> categories[index].title },
            ) { index ->
                val category = categories[index]
                FlavorCard(
                    modifier = Modifier.fillMaxWidth(),
                    style = FlavorCardStyle.Outlined,
                    onClick = category.onClick,
                ) {
                    Text(
                        text = category.title,
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Text(
                        text = category.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = Flavor.tokens.spacingXs),
                    )
                }
            }
        }
    }
}
