package com.ifeel.components.ui.components.common.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ifeel.components.ui.theme.color_danger_700
import com.ifeel.components.ui.theme.text.BodyTextStyle

@Composable
internal fun ErrorText(text: String, modifier: Modifier = Modifier) = Text(
    text = text,
    modifier = modifier,
    style = BodyTextStyle.Body14Regular.toTextStyle().copy(color = color_danger_700),
)