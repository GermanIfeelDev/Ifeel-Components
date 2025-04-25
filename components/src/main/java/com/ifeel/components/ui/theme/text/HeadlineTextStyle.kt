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
 * @property color Defaults to [color_text_600].
 * @property fontSize
 * @property lineHeight
 * @property fontWeight Defaults to [FontWeight.Normal].
 * @property fontFamily Defaults to [primaryFontFamily].
 * @property fontStyle Defaults to [FontStyle.Normal].
 */
sealed class HeadlineTextStyle(
    color: Color = color_text_600,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = primaryFontFamily,
    fontStyle: FontStyle = FontStyle.Normal,
) : IfeelTextStyle(color, fontSize, lineHeight, fontWeight, fontFamily, fontStyle) {

    data object H1SemiboldSecondary : HeadlineTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = DEFAULT_H1_FONT_SIZE.sp,
        lineHeight = DEFAULT_H1_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily
    )

    data object H1MediumSecondary : HeadlineTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = DEFAULT_H1_FONT_SIZE.sp,
        lineHeight = DEFAULT_H1_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily
    )

    data object H2SemiBoldSecondary : HeadlineTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = DEFAULT_H2_FONT_SIZE.sp,
        lineHeight = DEFAULT_H2_LINE_HEIGHT.sp
    )

    data object H2MediumSecondary : HeadlineTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = DEFAULT_H2_FONT_SIZE.sp,
        lineHeight = DEFAULT_H2_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily
    )

    data object H3SemiBold : HeadlineTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 30.sp
    )

    data object H3SemiboldSecondary : HeadlineTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = DEFAULT_H3_FONT_SIZE.sp,
        lineHeight = DEFAULT_H3_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily,
    )

    data object H3MediumSecondary : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.Medium,
        fontSize = DEFAULT_H3_FONT_SIZE.sp,
        lineHeight = DEFAULT_H3_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily,
    )

    data object H4SemiBold : HeadlineTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 24.sp
    )

    data object H4SemiBoldSecondary : HeadlineTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = DEFAULT_H4_FONT_SIZE.sp,
        lineHeight = DEFAULT_H4_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily,
    )

    data object H4MediumSecondary : HeadlineTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = DEFAULT_H4_FONT_SIZE.sp,
        lineHeight = DEFAULT_H4_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily,
    )

    companion object {
        private const val DEFAULT_H1_FONT_SIZE = 24
        private const val DEFAULT_H1_LINE_HEIGHT = 44
        private const val DEFAULT_H2_FONT_SIZE = 24
        private const val DEFAULT_H2_LINE_HEIGHT = 36
        private const val DEFAULT_H3_FONT_SIZE = 24
        private const val DEFAULT_H3_LINE_HEIGHT = 28
        private const val DEFAULT_H4_FONT_SIZE = 22
        private const val DEFAULT_H4_LINE_HEIGHT = 28
    }
}


