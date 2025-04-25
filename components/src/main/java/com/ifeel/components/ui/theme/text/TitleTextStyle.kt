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
 * @property color
 * @property fontSize
 * @property lineHeight
 * @property fontWeight Defaults to [FontWeight.Normal].
 * @property fontFamily Defaults to [primaryFontFamily].
 * @property fontStyle Defaults to [FontStyle.Normal].
 */
sealed class TitleTextStyle(
    color: Color,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = primaryFontFamily,
    fontStyle: FontStyle = FontStyle.Normal
) : IfeelTextStyle(color, fontSize, lineHeight, fontWeight, fontFamily, fontStyle) {

    data object TitleSemiBold : TitleTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.SemiBold,
        fontSize = TITLE_SEMIBOLD_FONT_SIZE.sp,
        lineHeight = TITLE_SEMIBOLD_LINE_HEIGHT.sp
    )

    data object TitleMedium : TitleTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.Medium,
        fontSize = TITLE_MEDIUM_FONT_SIZE.sp,
        lineHeight = TITLE_MEDIUM_LINE_HEIGHT.sp,
        fontFamily = secondaryFontFamily
    )

    companion object {
        private const val TITLE_SEMIBOLD_FONT_SIZE = 18
        private const val TITLE_SEMIBOLD_LINE_HEIGHT = 22

        private const val TITLE_MEDIUM_FONT_SIZE = 20
        private const val TITLE_MEDIUM_LINE_HEIGHT = 24
    }
}