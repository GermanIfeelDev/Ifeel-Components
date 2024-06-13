package com.ifeel.components.ui.theme.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ifeel.components.ui.theme.color_text_600
import com.ifeel.components.ui.theme.recoletaFontFamily
import com.ifeel.components.ui.theme.sofiaProFontFamily


/**
 * Sealed class representing different text styles for headlines used in the application.
 *
 * @property color
 * @property fontSize
 * @property lineHeight
 * @property fontWeight Defaults to [FontWeight.Normal].
 * @property fontFamily Defaults to [sofiaProFontFamily].
 * @property fontStyle Defaults to [FontStyle.Normal].
 */
sealed class HeadlineTextStyle(
    color: Color,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = sofiaProFontFamily,
    fontStyle: FontStyle = FontStyle.Normal
) : IfeelTextStyle(color, fontSize, lineHeight, fontWeight, fontFamily, fontStyle) {

    /**
     * @property color [color_text_600].
     * @property fontSize 28sp.
     * @property lineHeight 36sp.
     * @property fontWeight [FontWeight.SemiBold].
     */
    data object H2SemiBold : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 36.sp
    )

    /**
     * @property color [color_text_600].
     * @property fontSize 24sp.
     * @property lineHeight 32sp.
     * @property fontWeight [FontWeight.SemiBold].
     */
    data object H3Semibold : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp
    )

    /**
     * @property color [color_text_600].
     * @property fontSize 22sp.
     * @property lineHeight 28sp.
     * @property fontWeight [FontWeight.SemiBold].
     */
    data object H4SemiBold : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    )

    /**
     * @property color [color_text_600].
     * @property fontSize 24sp.
     * @property lineHeight 28sp.
     * @property fontWeight [FontWeight.Medium].
     * @property fontFamily [recoletaFontFamily].
     */
    data object H3MediumRecoleta : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        fontFamily = recoletaFontFamily,
        lineHeight = 28.sp
    )

    /**
     * @property color [color_text_600].
     * @property fontSize 22sp.
     * @property lineHeight 28sp.
     * @property fontWeight [FontWeight.Medium].
     * @property fontFamily [recoletaFontFamily].
     */
    data object H4MediumRecoleta : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        fontFamily = recoletaFontFamily,
        lineHeight = 28.sp
    )

    /**
     * @property color [color_text_600].
     * @property fontSize 18sp.
     * @property lineHeight 24sp.
     * @property fontWeight [FontWeight.SemiBold].
     */
    data object SubtitleSemibold : HeadlineTextStyle(
        color = color_text_600,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp
    )
}


