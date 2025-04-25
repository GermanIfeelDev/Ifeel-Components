package com.ifeel.components.ui.theme.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ifeel.components.ui.theme.color_text_600
import com.ifeel.components.ui.theme.primaryFontFamily
import com.ifeel.components.ui.theme.secondaryFontFamily

/**
 * Sealed class representing different text styles for subtitles used in the application.
 *
 * @property color Defaults to [color_text_600].
 * @property fontSize Defaults to [DEFAULT_FONT_SIZE].
 * @property lineHeight Defaults to [DEFAULT_LINE_HEIGHT].
 * @property fontWeight Defaults to [FontWeight.Normal].
 * @property fontFamily Defaults to [primaryFontFamily].
 * @property fontStyle Defaults to [FontStyle.Normal].
 */
sealed class SubtitleTextStyle(
    color: Color = color_text_600,
    fontSize: TextUnit = DEFAULT_FONT_SIZE.sp,
    lineHeight: TextUnit = DEFAULT_LINE_HEIGHT.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = primaryFontFamily,
    fontStyle: FontStyle = FontStyle.Normal,
) : IfeelTextStyle(color, fontSize, lineHeight, fontWeight, fontFamily, fontStyle) {

    data object SubtitleSemibold : SubtitleTextStyle(
        fontWeight = FontWeight.SemiBold,
    )

    data object SubtitleSemiboldSecondary : SubtitleTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = SECONDARY_FONT_SIZE.sp,
        lineHeight = SECONDARY_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily,
    )

    data object SubtitleMediumSecondary : SubtitleTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = SECONDARY_FONT_SIZE.sp,
        lineHeight = SECONDARY_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily,
    )

    data object SubtitleRegular : SubtitleTextStyle()

    companion object {
        private const val DEFAULT_FONT_SIZE = 16
        private const val DEFAULT_LINE_HEIGHT = 22

        private const val SECONDARY_FONT_SIZE = 18
        private const val SECONDARY_LINE_HEIGHT = 24
    }
}