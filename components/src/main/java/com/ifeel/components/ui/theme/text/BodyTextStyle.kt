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
 * Sealed class representing different body text styles used in the application.
 *
 * @property color
 * @property fontSize
 * @property lineHeight
 * @property fontWeight Defaults to [FontWeight.Normal].
 * @property fontFamily Defaults to [sofiaProFontFamily].
 * @property fontStyle Defaults to [FontStyle.Normal].
 */
sealed class BodyTextStyle(
    color: Color,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = sofiaProFontFamily,
    fontStyle: FontStyle = FontStyle.Normal
) : IfeelTextStyle(color, fontSize, lineHeight, fontWeight, fontFamily, fontStyle) {

    /**
     * @property color [color_text_600].
     * @property fontSize 16sp.
     * @property lineHeight 24sp.
     * @property fontWeight [FontWeight.SemiBold].
     */
    data object Body16SemiBold : BodyTextStyle(
        color = color_text_600,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.SemiBold
    )

    /**
     * @property color [color_text_600].
     * @property fontSize 16sp.
     * @property lineHeight 24sp.
     */
    data object Body16Regular : BodyTextStyle(
        color = color_text_600,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    )

    /**
     * @property color [color_text_600].
     * @property fontSize 14sp.
     * @property lineHeight 20sp.
     */
    data object Body14Regular: BodyTextStyle(
        color = color_text_600,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )
}
