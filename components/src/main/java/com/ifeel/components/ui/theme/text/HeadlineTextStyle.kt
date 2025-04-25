package com.ifeel.components.ui.theme.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ifeel.components.ui.theme.color_text_600
import com.ifeel.components.ui.theme.secondaryFontFamily
import com.ifeel.components.ui.theme.primaryFontFamily


/**
 * Sealed class representing different text styles for headlines used in the application.
 *
 * @property color
 * @property fontSize
 * @property lineHeight
 * @property fontWeight Defaults to [FontWeight.Normal].
 * @property fontFamily Defaults to [primaryFontFamily].
 * @property fontStyle Defaults to [FontStyle.Normal].
 */
sealed class HeadlineTextStyle(
    color: Color,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = primaryFontFamily,
    fontStyle: FontStyle = FontStyle.Normal,
) : IfeelTextStyle(color, fontSize, lineHeight, fontWeight, fontFamily, fontStyle) {

    data object H2SemiBold : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.SemiBold,
        fontSize = DEFAULT_H2_FONT_SIZE.sp,
        lineHeight = DEFAULT_H2_LINE_HEIGHT.sp
    )

    data object H3Semibold : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.SemiBold,
        fontSize = DEFAULT_H3_FONT_SIZE.sp,
        lineHeight = DEFAULT_H3_LINE_HEIGHT.sp
    )

    data object H3MediumSecondary : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.Medium,
        fontSize = DEFAULT_H3_FONT_SIZE.sp,
        lineHeight = DEFAULT_H3_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily,
    )

    data object H4SemiBold : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.SemiBold,
        fontSize = DEFAULT_H4_FONT_SIZE.sp,
        lineHeight = DEFAULT_H4_LINE_HEIGHT.sp
    )

    data object H4MediumSecondary : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.SemiBold,
        fontSize = DEFAULT_H4_FONT_SIZE.sp,
        lineHeight = DEFAULT_H4_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily,
    )

    companion object {
        private const val DEFAULT_H2_FONT_SIZE = 24
        private const val DEFAULT_H2_LINE_HEIGHT = 36
        private const val DEFAULT_H3_FONT_SIZE = 24
        private const val DEFAULT_H3_LINE_HEIGHT = 28
        private const val DEFAULT_H4_FONT_SIZE = 22
        private const val DEFAULT_H4_LINE_HEIGHT = 28
    }
}


