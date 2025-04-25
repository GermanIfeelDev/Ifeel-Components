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

    data object ButtonLargeSemiBold : ButtonTextStyle(
        fontSize = LARGE_FONT_SIZE.sp,
        lineHeight = LARGE_LINE_HEIGHT.sp,
        fontWeight = FontWeight.SemiBold,
    )

    data object ButtonDefaultSemiBold : ButtonTextStyle(
        fontSize = DEFAULT_FONT_SIZE.sp,
        lineHeight = DEFAULT_LINE_HEIGHT.sp,
        fontWeight = FontWeight.SemiBold,
    )

    data object ButtonDefaultRegular : ButtonTextStyle(
        fontSize = DEFAULT_FONT_SIZE.sp,
        lineHeight = DEFAULT_LINE_HEIGHT.sp,
    )

    data object ButtonSmallSemiBold : ButtonTextStyle(
        fontSize = SMALL_FONT_SIZE.sp,
        lineHeight = SMALL_LINE_HEIGHT.sp,
        fontWeight = FontWeight.SemiBold,
    )

    companion object {
        private const val DEFAULT_FONT_SIZE = 14
        private const val DEFAULT_LINE_HEIGHT = 20

        private const val LARGE_FONT_SIZE = 16
        private const val LARGE_LINE_HEIGHT = 20

        private const val SMALL_FONT_SIZE = 12
        private const val SMALL_LINE_HEIGHT = 16
    }
}