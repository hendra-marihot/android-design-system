package com.hendramarihot.flavor.card

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hendramarihot.flavor.theme.Flavor
import com.hendramarihot.flavor.theme.FlavorTheme
import com.hendramarihot.flavor.theme.FlavorTokens

enum class FlavorCardStyle { Elevated, Filled, Outlined }

@Composable
fun FlavorCard(
    modifier: Modifier = Modifier,
    style: FlavorCardStyle = FlavorCardStyle.Filled,
    onClick: (() -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(FlavorTokens.Default.spacingMd),
    content: @Composable ColumnScope.() -> Unit,
) {
    val innerContent: @Composable ColumnScope.() -> Unit = {
        Column(modifier = Modifier.padding(contentPadding), content = content)
    }

    when (style) {
        FlavorCardStyle.Elevated -> if (onClick != null) {
            Card(onClick = onClick, modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = Flavor.tokens.elevationMd), content = innerContent)
        } else {
            Card(modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = Flavor.tokens.elevationMd), content = innerContent)
        }
        FlavorCardStyle.Filled -> if (onClick != null) {
            Card(onClick = onClick, modifier = modifier, colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), content = innerContent)
        } else {
            Card(modifier = modifier, colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant), content = innerContent)
        }
        FlavorCardStyle.Outlined -> if (onClick != null) {
            OutlinedCard(onClick = onClick, modifier = modifier, content = innerContent)
        } else {
            OutlinedCard(modifier = modifier, content = innerContent)
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun FlavorCardPreview() {
    FlavorTheme {
        Column(
            modifier = Modifier.padding(Flavor.tokens.spacingMd),
            verticalArrangement = Arrangement.spacedBy(Flavor.tokens.spacingSm),
        ) {
            FlavorCardStyle.entries.forEach { style ->
                FlavorCard(style = style) {
                    Text("${style.name} Card")
                }
            }
        }
    }
}
