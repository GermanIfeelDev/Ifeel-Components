package com.ifeel.components.ui.components.common.chat

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_text_700
import com.ifeel.components.ui.theme.text.BodyTextStyle

@Composable
fun ChatMessageVideoSession(
    @DrawableRes imageId: Int,
    title: String,
    text: String,
    modifier: Modifier = Modifier,
    date: String? = null,
) {
    val messagePaddingBottom = if (date != null) 26.dp else 0.dp

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        if (date != null) {
            ChatDateText(
                text = date,
                modifier = Modifier
                    .padding(bottom = messagePaddingBottom)
                    .align(Alignment.CenterHorizontally)
            )
        }

        Icon(painterResource(imageId), contentDescription = null, modifier = Modifier.size(20.dp))

        Text(
            text = title,
            style = BodyTextStyle.Body16Regular.toTextStyle().copy(),
            color = color_text_700,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = text,
            style = BodyTextStyle.Body14Regular.toTextStyle(),
            color = color_text_700,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun ChatMessageVideoSessionPreview() {
    IfeelComponentsTheme {
        ChatMessageVideoSession(
            imageId = R.drawable.message_status_sending_ic,
            title = "Video title",
            text = "Video description",
            date = "Lunes, 10 junio 2024",
        )

    }

}