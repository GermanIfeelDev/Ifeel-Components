package com.ifeel.components.ui.components.common.chat

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.ui.extension.surface
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_background_5
import com.ifeel.components.ui.theme.color_background_6
import com.ifeel.components.ui.theme.text.CaptionTextStyle

/**
 * Displays a date text within a styled box.
 *
 * For the design details, refer to the [Maccabi Figma design](https://www.figma.com/design/7GJjL34sYDK9gXPX5RRjmB/Maccabi?node-id=1098-13555&t=y1FUdrSyqexAwBMO-4).
 *
 * @param text The text to display, typically a date.
 * @param modifier Modifier for this layout. Defaults to Modifier.
 */
@Composable
internal fun ChatDateText(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.surface(
            shape = RoundedCornerShape(6.dp),
            backgroundColor = color_background_5,
            border = BorderStroke(1.dp, color = color_background_6)
        )
    ) {
        Text(
            text = text,
            style = CaptionTextStyle.Caption12Regular.toTextStyle(),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
        )
    }
}

@Preview
@Composable
fun ChatDateTextPreview() {
    IfeelComponentsTheme {
        ChatDateText(text = "March 1st, 2024")
    }
}