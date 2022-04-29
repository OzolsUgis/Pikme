package com.ugisozols.pikme.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.ugisozols.core_ui.*

private val DarkColorPalette = darkColors(
    primary = White,
    primaryVariant = DarkGray,
    secondary = LightGray
)

private val LightColorPalette = lightColors(
    primary = DarkGray,
    primaryVariant = LightGray,
    secondary = AppBlack
)

@Composable
fun PikmeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalSpacing provides Dimensions()) {
        val colors = if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }

        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}