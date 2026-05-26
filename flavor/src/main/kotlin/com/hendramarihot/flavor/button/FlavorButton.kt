package com.hendramarihot.flavor.button

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.hendramarihot.flavor.theme.Flavor
import com.hendramarihot.flavor.theme.FlavorTheme

enum class FlavorButtonStyle { Primary, Secondary, Outline, Text, Destructive }

@Composable
fun FlavorButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: FlavorButtonStyle = FlavorButtonStyle.Primary,
    enabled: Boolean = true,
    loading: Boolean = false,
    leadingIcon: ImageVector? = null,
) {
    val content: @Composable () -> Unit = {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(Flavor.tokens.iconSizeButton),
                strokeWidth = Flavor.tokens.strokeWidthSm,
            )
            Spacer(modifier = Modifier.width(Flavor.tokens.spacingSm))
        } else {
            leadingIcon?.let { icon ->
                Icon(icon, contentDescription = null, modifier = Modifier.size(Flavor.tokens.iconSizeButton))
                Spacer(modifier = Modifier.width(Flavor.tokens.spacingSm))
            }
        }
        Text(text)
    }

    when (style) {
        FlavorButtonStyle.Primary -> Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled && !loading,
            content = { content() },
        )
        FlavorButtonStyle.Secondary -> FilledTonalButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled && !loading,
            content = { content() },
        )
        FlavorButtonStyle.Outline -> OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled && !loading,
            content = { content() },
        )
        FlavorButtonStyle.Text -> TextButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled && !loading,
            content = { content() },
        )
        FlavorButtonStyle.Destructive -> Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled && !loading,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error,
                contentColor = MaterialTheme.colorScheme.onError,
            ),
            content = { content() },
        )
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun FlavorButtonPreview() {
    FlavorTheme {
        Column(modifier = Modifier.padding(Flavor.tokens.spacingMd)) {
            FlavorButtonStyle.entries.forEach { style ->
                FlavorButton(text = style.name, onClick = {}, style = style)
                Spacer(modifier = Modifier.size(Flavor.tokens.spacingSm))
            }
            FlavorButton(text = "Loading", onClick = {}, loading = true)
        }
    }
}
