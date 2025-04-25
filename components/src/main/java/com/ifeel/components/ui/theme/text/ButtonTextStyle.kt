package com.ifeel.components.ui.theme.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ifeel.components.ui.theme.primaryFontFamily

/**
 * Sealed class representing different text styles for buttons used in the application.
 *
 * @property fontSize
 * @property lineHeight
 * @property color Defaults to [Color.Unspecified].
 * @property fontWeight Defaults to [FontWeight.Normal].
 * @property fontFamily Defaults to [primaryFontFamily].
 * @property fontStyle Defaults to [FontStyle.Normal].
 */
sealed class ButtonTextStyle(
    fontSize: TextUnit,
    lineHeight: TextUnit,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = primaryFontFamily,
    fontStyle: FontStyle = FontStyle.Normal
) : IfeelTextStyle(color, fontSize, lineHeight, fontWeight, fontFamily, fontStyle) {

    data object ButtonDefaultSemiBold : ButtonTextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.SemiBold,
    )

    data object ButtonDefaultRegular : ButtonTextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
    )
}