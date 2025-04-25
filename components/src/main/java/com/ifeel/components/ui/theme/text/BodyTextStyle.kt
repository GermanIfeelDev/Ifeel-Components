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
 * Sealed class representing different body text styles used in the application.
 *
 * @property color Defaults to [color_text_600].
 * @property fontSize
 * @property lineHeight
 * @property fontWeight Defaults to [FontWeight.Normal].
 * @property fontFamily Defaults to [primaryFontFamily].
 * @property fontStyle Defaults to [FontStyle.Normal].
 */
sealed class BodyTextStyle(
    color: Color = color_text_600,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = primaryFontFamily,
    fontStyle: FontStyle = FontStyle.Normal
) : IfeelTextStyle(color, fontSize, lineHeight, fontWeight, fontFamily, fontStyle) {

    data object Body16SemiBold : BodyTextStyle(
        fontSize = BODY_16_FONT_SIZE.sp,
        lineHeight = BODY_16_LINE_HEIGHT.sp,
        fontWeight = FontWeight.SemiBold
    )

    data object Body16MediumSecondary : BodyTextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = secondaryFontFamily
    )

    data object Body16Regular : BodyTextStyle(
        fontSize = BODY_16_FONT_SIZE.sp,
        lineHeight = BODY_16_LINE_HEIGHT.sp,
    )

    data object Body14SemiBold : BodyTextStyle(
        fontSize = BODY_14_FONT_SIZE.sp,
        lineHeight = BODY_14_LINE_HEIGHT.sp,
        fontWeight = FontWeight.SemiBold
    )

    data object Body14Regular: BodyTextStyle(
        fontSize = BODY_14_FONT_SIZE.sp,
        lineHeight = BODY_14_LINE_HEIGHT.sp
    )

    companion object {
        private const val BODY_16_FONT_SIZE = 14
        private const val BODY_16_LINE_HEIGHT = 22

        private const val BODY_14_FONT_SIZE = 12
        private const val BODY_14_LINE_HEIGHT = 20
    }
}
