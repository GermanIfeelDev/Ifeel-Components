package com.ifeel.components.ui.components.common.chat

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.extension.surface
import com.ifeel.components.ui.theme.color_background_6
import com.ifeel.components.ui.theme.color_text_500
import com.ifeel.components.ui.theme.color_text_700
import com.ifeel.components.ui.theme.text.BodyTextStyle
import com.ifeel.components.ui.theme.text.CaptionTextStyle

private val messageShapeDp = 22.dp
private val contentMessageHorizontalPaddingUnit = 16.dp

/**
 * Displays a chat message sent by the user, optionally including a date.
 *
 * @param text The message text to display.
 * @param sendOn The time the message was sent.
 * @param isSaved Indicates if the message is saved.
 * @param isPending Indicates if the message is pending.
 * @param modifier Modifier for this layout. Defaults to Modifier.
 * @param date An optional date to display above the message in [ChatDateText] composable.
 */
@Composable
fun ChatMessageOwn(
    text: String,
    sendOn: String,
    isSaved: Boolean,
    isPending: Boolean,
    modifier: Modifier = Modifier,
    date: String? = null,
) {
    val messagePaddingBottom = if (date != null) 26.dp else 0.dp

    Column(modifier = modifier.fillMaxWidth()) {
        if (date != null) {
            ChatDateText(
                text = date,
                modifier = Modifier
                    .padding(bottom = messagePaddingBottom)
                    .align(Alignment.CenterHorizontally)
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 26.dp, end = 72.dp)
                .surface(
                    shape = RoundedCornerShape(
                        topStart = messageShapeDp,
                        topEnd = messageShapeDp,
                        bottomEnd = messageShapeDp
                    ), backgroundColor = Color.White, BorderStroke(1.dp, color = color_background_6)
                )
        ) {
            Text(
                text = text,
                style = BodyTextStyle.Body14Regular.toTextStyle(),
                color = color_text_700,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(
                    start = contentMessageHorizontalPaddingUnit,
                    end = contentMessageHorizontalPaddingUnit,
                    top = 12.dp
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(
                        start = contentMessageHorizontalPaddingUnit,
                        end = contentMessageHorizontalPaddingUnit,
                        bottom = 8.dp,
                        top = 4.dp
                    )
                    .align(Alignment.End)
            ) {
                Text(
                    text = sendOn,
                    style = CaptionTextStyle.Caption12Regular.toTextStyle(),
                    color = color_text_500,
                )
                Image(
                    painter = painterResource(id = getStatusMessageIcon(isSaved, isPending)),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp).padding(start = 4.dp)
                )
            }
        }
    }
}

@DrawableRes
private fun getStatusMessageIcon(isSaved: Boolean, isPending: Boolean): Int = if (isSaved) {
    R.mipmap.message_saved
} else if (isPending) {
    R.drawable.message_status_sending_ic
} else {
    R.mipmap.message_not_saved
}


@Preview
@Composable
private fun ChatMessageOwnPreview() {
    ChatMessageOwn(
        text = "Welcome to ifeel, I am your personal agent and my role is to help you to find your find your plan",
        sendOn = "10:00",
        isSaved = false,
        isPending = true,
        date = "May 1st, 2024",
    )
}