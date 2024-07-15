package com.example.composescreens.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val Pink80 = Color(0xFFEFB8C8)
val Pink40 = Color(0xFF7D5260)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Mauve = Color(0xFF65228F)
val Green = Color(0xFF44C969)
val Yellow = Color(0xABFFEB3B)
val Orange = Color(0xFFFF9F0A)
val transparent= Color(0x00000000)

val Gray = Color(0xFF8E8E93)
val LightGray = Color(0xFFEFEFEF)
val DarkGray = Color(0xFF8E8E93)



val DarkPrimary = Color(0xFF0A84FF)
val OnDarkPrimary = Color(0xFFFFFFFF)
val DarkCard = Color(0xFF262626)
val DarkBorder = Color(0xFF302F2F)
val DarkBackground = Color(0xFF000000)
val OnDarkBackground1 = Color(0xFF1C1C1E)
val OnDarkBackground2 = Color(0xFF8E8E93)
val OnDarkBackground3 = Color(0x1A000000)
val OnDarkBackground4 = Color(0x99EBEBF5)
val OnDarkBackground5 = Color(0xFF1C1C1E)
val DarkStatusBar = Color(0xFFFFFFFF)
val DarkRed60 = Color(0x99FF3838)
val DarkRed = Color(0xFFFF6B6B)

@Immutable
data class CustomColorsPalette(
    val primary: Color = Color.Unspecified,
    val onPrimary: Color = Color.Unspecified,
    val border: Color = Color.Unspecified,
    val card: Color = Color.Unspecified,
    val statusBar: Color = Color.Unspecified,
    val background: Color = Color.Unspecified,
    val onBackground1: Color = Color.Unspecified,
    val onBackground2: Color = Color.Unspecified,
    val onBackground3: Color = Color.Unspecified,
    val onBackground4: Color = Color.Unspecified,
    val onBackground5: Color = Color.Unspecified,
    val gray: Color = Color.Unspecified,
    val lightGray: Color = Color.Unspecified,
    val darkGray: Color = Color.Unspecified,
    val yellow: Color = Color.Unspecified,
    val green: Color = Color.Unspecified,
    val mauve: Color = Color.Unspecified,
    val orange: Color = Color.Unspecified,
    val white: Color = Color.Unspecified,
    val black: Color = Color.Unspecified,
    val red: Color = Color.Unspecified,
    val red60: Color = Color.Unspecified,
    val transparent: Color = Color.Unspecified
)