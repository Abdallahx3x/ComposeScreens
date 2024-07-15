package com.example.composescreens.presentation.theme

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext

@SuppressLint("CompositionLocalNaming")
private val composeScreensCustomColors = staticCompositionLocalOf { CustomColorsPalette() }


private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    tertiary = Pink80,
    background = DarkBackground
)

private val LightColorScheme = lightColorScheme(
    primary = DarkPrimary,
    tertiary = Pink40,
    background = DarkBackground
)


val onDarkCustomColorsPalette = CustomColorsPalette(
    primary = DarkPrimary,
    onPrimary = OnDarkPrimary,
    border = DarkBorder,
    card = DarkCard,
    statusBar = DarkStatusBar,
    background = DarkBackground,
    onBackground1 = OnDarkBackground1,
    onBackground2 = OnDarkBackground2,
    onBackground3 = OnDarkBackground3,
    onBackground4 = OnDarkBackground4,
    onBackground5 = OnDarkBackground5,
    gray = Gray,
    lightGray = LightGray,
    darkGray = DarkGray,
    yellow = Yellow,
    green = Green,
    orange = Orange,
    mauve = Mauve,
    white = White,
    black = Black,
    red60 = DarkRed60,
    red = DarkRed,
    transparent = transparent
)


val MaterialTheme.customColors: CustomColorsPalette
    @Composable
    @ReadOnlyComposable
    get() = composeScreensCustomColors.current

@Composable
fun ComposeScreensTheme(
    darkTheme: Boolean = true,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(composeScreensCustomColors provides onDarkCustomColorsPalette) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}