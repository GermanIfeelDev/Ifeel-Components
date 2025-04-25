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
 * Sealed class representing different text styles for titles used in the application.
 *
 * @property color Defaults to [color_text_600].
 * @property fontSize
 * @property lineHeight
 * @property fontWeight Defaults to [FontWeight.Normal].
 * @property fontFamily Defaults to [primaryFontFamily].
 * @property fontStyle Defaults to [FontStyle.Normal].
 */
sealed class TitleTextStyle(
    color: Color = color_text_600,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = primaryFontFamily,
    fontStyle: FontStyle = FontStyle.Normal
) : IfeelTextStyle(color, fontSize, lineHeight, fontWeight, fontFamily, fontStyle) {

    data object TitleSemiBold : TitleTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = TITLE_DEFAULT_FONT_SIZE.sp,
        lineHeight = TITLE_DEFAULT_LINE_HEIGHT.sp
    )

    data object TitleMediumSecondary : TitleTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = TITLE_MEDIUM_FONT_SIZE.sp,
        lineHeight = TITLE_MEDIUM_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily
    )

    data object TitleRegular : TitleTextStyle(
        fontSize = TITLE_DEFAULT_FONT_SIZE.sp,
        lineHeight = TITLE_DEFAULT_LINE_HEIGHT.sp
    )

    companion object {
        private const val TITLE_DEFAULT_FONT_SIZE = 18
        private const val TITLE_DEFAULT_LINE_HEIGHT = 22

        private const val TITLE_MEDIUM_FONT_SIZE = 20
        private const val TITLE_MEDIUM_LINE_HEIGHT = 24
    }
}