package com.hendramarihot.flavor.state

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hendramarihot.flavor.button.FlavorButton
import com.hendramarihot.flavor.button.FlavorButtonStyle
import com.hendramarihot.flavor.theme.Flavor
import com.hendramarihot.flavor.theme.FlavorTheme

@Composable
fun FlavorErrorView(
    message: String,
    modifier: Modifier = Modifier,
    onRetry: (() -> Unit)? = null,
    retryText: String = "Retry",
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = Icons.Outlined.ErrorOutline,
            contentDescription = null,
            modifier = Modifier.size(Flavor.tokens.iconSizeLg * 2),
            tint = MaterialTheme.colorScheme.error,
        )
        Spacer(modifier = Modifier.height(Flavor.tokens.spacingMd))
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
        )
        if (onRetry != null) {
            Spacer(modifier = Modifier.height(Flavor.tokens.spacingLg))
            FlavorButton(
                text = retryText,
                onClick = onRetry,
                style = FlavorButtonStyle.Secondary,
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun FlavorErrorViewPreview() {
    FlavorTheme {
        FlavorErrorView(message = "Something went wrong", onRetry = {})
    }
}
