package com.ifeel.components.ui.theme.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

sealed class IfeelTextStyle(
    private val color: Color,
    private val fontSize: TextUnit,
    private val lineHeight: TextUnit,
    private val fontWeight: FontWeight,
    private val fontFamily: FontFamily,
    private val fontStyle: FontStyle
) {
    fun toTextStyle(): TextStyle = TextStyle(
        color = color,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        lineHeight = lineHeight,
    )
}