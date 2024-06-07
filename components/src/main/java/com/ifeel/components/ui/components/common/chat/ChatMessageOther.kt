package com.ifeel.components.ui.components.common.chat

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.ui.extension.surface
import com.ifeel.components.ui.theme.color_background_6
import com.ifeel.components.ui.theme.color_brand_primary_light_400
import com.ifeel.components.ui.theme.color_text_500
import com.ifeel.components.ui.theme.color_text_700
import com.ifeel.components.ui.theme.text.BodyTextStyle
import com.ifeel.components.ui.theme.text.CaptionTextStyle

private val messageShapeDp = 22.dp
private val contentMessageHorizontalPaddingUnit = 16.dp

@Composable
fun ChatMessageOther(
    text: String,
    sendOn: String,
    modifier: Modifier = Modifier,
    date: String? = null,
) {
    val messagePaddingTop = if (date != null)
        26.dp
    else 0.dp
    Column(modifier = modifier.fillMaxWidth()) {
        if (date != null) {
            ChatDateText(
                text = date,
                modifier = Modifier
                    .padding(bottom = messagePaddingTop)
                    .align(Alignment.CenterHorizontally)
            )
        }

        Column(
            modifier = Modifier
                .padding(end = 26.dp, start = 72.dp)
                .surface(
                    shape = RoundedCornerShape(
                        topStart = messageShapeDp,
                        topEnd = messageShapeDp,
                        bottomStart = messageShapeDp
                    ), backgroundColor = color_brand_primary_light_400,
                    border = BorderStroke(1.dp, color = color_background_6)
                )
                .align(Alignment.End)
        ) {
            Text(
                text = text,
                style = BodyTextStyle.Body14Regular.toTextStyle(),
                textAlign = TextAlign.Start,
                color = color_text_700,
                modifier = Modifier
                    .padding(
                        start = contentMessageHorizontalPaddingUnit,
                        end = contentMessageHorizontalPaddingUnit,
                        top = 12.dp
                    )
                    .align(Alignment.Start)
            )
            Text(
                text = sendOn,
                style = CaptionTextStyle.Caption12Regular.toTextStyle(),
                color = color_text_500,
                modifier = Modifier
                    .padding(
                        end = contentMessageHorizontalPaddingUnit,
                        bottom = 8.dp,
                        top = 4.dp
                    )
                    .align(Alignment.End)
            )
        }
    }


}

@Preview
@Composable
fun ChatMessageOtherPreview() {
    ChatMessageOther(
        text = "Welcome to ifeel, I am your personal agent and my role is to help you to find your find your plan",
        sendOn = "10:00",
        date = "May 1st, 2024",
    )
}