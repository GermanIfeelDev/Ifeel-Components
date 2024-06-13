package com.ifeel.components.ui.theme.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ifeel.components.ui.theme.sofiaProFontFamily

/**
 * Sealed class representing different text styles for buttons used in the application.
 *
 * @property fontSize
 * @property lineHeight
 * @property color Defaults to [Color.Unspecified].
 * @property fontWeight Defaults to [FontWeight.Normal].
 * @property fontFamily Defaults to [sofiaProFontFamily].
 * @property fontStyle Defaults to [FontStyle.Normal].
 */
sealed class ButtonTextStyle(
    fontSize: TextUnit,
    lineHeight: TextUnit,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = sofiaProFontFamily,
    fontStyle: FontStyle = FontStyle.Normal
) : IfeelTextStyle(color, fontSize, lineHeight, fontWeight, fontFamily, fontStyle) {

    /**
     * @property fontSize 16sp.
     * @property lineHeight 20sp.
     * @property fontWeight [FontWeight.SemiBold].
     */
    data object ButtonDefaultSemiBold : ButtonTextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.SemiBold,
    )

    /**
     * @property fontSize 16sp.
     * @property lineHeight 20sp.
     */
    data object ButtonDefaultRegular : ButtonTextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
    )
}