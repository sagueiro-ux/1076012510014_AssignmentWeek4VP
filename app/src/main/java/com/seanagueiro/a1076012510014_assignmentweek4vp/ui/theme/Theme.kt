package com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val AppColorScheme = lightColorScheme(
    primary = CarOrange,
    secondary = HeroGold,
    tertiary = Pink40
)

@Composable
fun Week4Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        content = content
    )
}