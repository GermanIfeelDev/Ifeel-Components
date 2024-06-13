package com.ifeel.components.ui.theme.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ifeel.components.ui.theme.color_text_600
import com.ifeel.components.ui.theme.sofiaProFontFamily

/**
 * Sealed class representing different text styles for captions used in the application.
 *
 * @property color
 * @property fontSize
 * @property lineHeight
 * @property fontWeight Defaults to [FontWeight.Normal].
 * @property fontFamily Defaults to [sofiaProFontFamily].
 * @property fontStyle Defaults to [FontStyle.Normal].
 */
sealed class CaptionTextStyle(
    color: Color,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = sofiaProFontFamily,
    fontStyle: FontStyle = FontStyle.Normal
) : IfeelTextStyle(color, fontSize, lineHeight, fontWeight, fontFamily, fontStyle) {

    /**
     * @property color [color_text_600].
     * @property fontSize 12sp.
     * @property lineHeight 16sp.
     */
    data object Caption12Regular : CaptionTextStyle(
        color = color_text_600,
        fontSize = 12.sp,
        lineHeight = 16.sp
    )
}
