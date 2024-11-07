package com.example.sportteamapplication.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = DynamoBlue,
    secondary = DynamoYellow,
    tertiary = LightBlue,
    background = White,
    surface = LightGrey,
    onPrimary = White,
    onSecondary = DynamoBlue,
    onTertiary = White,
    onBackground = DynamoBlue,
    onSurface = DynamoBlue
)

private val DarkColorScheme = lightColorScheme(
    primary = DynamoBlue,
    secondary = DynamoYellow,
    tertiary = LightBlue,
    background = Black,
    surface = LightBlack,
    onPrimary = White,
    onSecondary = DynamoBlue,
    onTertiary = White,
    onBackground = White,
    onSurface = White
)

@Composable
fun SportTeamApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
