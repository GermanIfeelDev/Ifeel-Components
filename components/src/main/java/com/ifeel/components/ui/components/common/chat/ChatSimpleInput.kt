package com.ifeel.components.ui.components.common.chat

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ifeel.components.ui.extension.surface
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_background_6
import com.ifeel.components.ui.theme.color_text_200
import com.ifeel.components.ui.theme.color_text_300
import com.ifeel.components.ui.theme.color_text_500
import com.ifeel.components.ui.theme.text.BodyTextStyle

/**
 * Displays a chat input UI with a text field, send button, and optional complementary action buttons.
 *
 * This component provides a full-width text input with overlay buttons for attachments and emojis,
 * plus a send button that's enabled only when there's text to send. The input field automatically
 * adjusts its padding based on whether complementary action buttons are shown.
 *
 * For the design details, refer to the [Maccabi Figma design](https://www.figma.com/design/7GJjL34sYDK9gXPX5RRjmB/Maccabi?node-id=1098-13561&t=qgmumeLMnzC5RWX1-4).
 *
 * @param message The current value of the input message.
 * @param onMessageChanged Lambda function invoked when the input message changes.
 * @param hint The hint text displayed in the input field when it's empty.
 * @param onSendMessageBtnClicked Lambda function invoked when the send button is clicked, passing the current message.
 * @param modifier Modifier for this layout. Defaults to Modifier.
 * @param showComplementaryActionButtons Whether to show the attachment and emoji buttons. Defaults to true.
 * @param enabled Whether the input and buttons are enabled. Defaults to true.
 * @param onEmojiBtnClicked Lambda function invoked when the emoji button is clicked. Only called when [showComplementaryActionButtons] is true.
 * @param onAttachmentBtnClicked Lambda function invoked when the attachment button is clicked. Only called when [showComplementaryActionButtons] is true.
 */
@Composable
fun ChatSimpleInput(
    message: String,
    onMessageChanged: (String) -> Unit,
    hint: String,
    onSendMessageBtnClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
    showComplementaryActionButtons: Boolean = true,
    enabled: Boolean = true,
    onEmojiBtnClicked: () -> Unit = {},
    onAttachmentBtnClicked: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        HorizontalDivider(color = color_background_6)

        ConstraintLayout(modifier = modifier.fillMaxWidth()) {
            val (attachmentBtn, emojiBtn, textInput, sendMessageBtn) = createRefs()

            OutlinedChatTextField(
                value = message,
                onValueChange = onMessageChanged,
                hint = hint,
                enabled = enabled,
                modifier = Modifier.constrainAs(textInput) {
                    start.linkTo(parent.start)
                    end.linkTo(sendMessageBtn.start)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(parent.top)
                    width = Dimension.fillToConstraints
                },
                decorationBoxModifier = if (showComplementaryActionButtons) {
                    Modifier.padding(start = 76.dp)
                } else {
                    Modifier.padding(start = 14.dp)
                }
            )

            if (showComplementaryActionButtons) {
                AttachmentButton(
                    onClick = onAttachmentBtnClicked,
                    isEnabled = enabled,
                    modifier = Modifier.constrainAs(attachmentBtn) {
                        start.linkTo(textInput.start, margin = 4.dp)
                        top.linkTo(textInput.top)
                        bottom.linkTo(textInput.bottom)
                    },
                )

                EmojiButton(
                    onClick = onEmojiBtnClicked,
                    isEnabled = enabled,
                    modifier = Modifier.constrainAs(emojiBtn) {
                        start.linkTo(attachmentBtn.end)
                        top.linkTo(textInput.top)
                        bottom.linkTo(textInput.bottom)
                    }
                )
            }

            SendMessageButton(
                onClick = { onSendMessageBtnClicked(message) },
                isEnabled = message.isNotBlank(),
                modifier = Modifier
                    .padding(start = 6.dp, bottom = 2.dp)
                    .constrainAs(sendMessageBtn) {
                        end.linkTo(parent.end)
                        bottom.linkTo(textInput.bottom)
                        top.linkTo(textInput.top)
                    }
            )
        }
    }
}

@Composable
@Preview
private fun ChatSimpleInputPreview() {
    IfeelComponentsTheme {
        var message by rememberSaveable { mutableStateOf("") }
        var message2 by rememberSaveable { mutableStateOf("") }
        val modifier = Modifier.padding(vertical = 12.dp, horizontal = 4.dp)

        Column {
            // Standard input with all buttons
            ChatSimpleInput(
                message = message,
                onMessageChanged = { message = it },
                hint = "Type your message",
                onSendMessageBtnClicked = {},
                modifier = modifier
            )

            // Disabled input
            ChatSimpleInput(
                message = "",
                onMessageChanged = {},
                hint = "Type your message (disabled)",
                enabled = false,
                onSendMessageBtnClicked = {},
                modifier = modifier
            )

            // Input without complementary buttons
            ChatSimpleInput(
                message = message2,
                onMessageChanged = { message2 = it },
                hint = "Type your message",
                showComplementaryActionButtons = false,
                onSendMessageBtnClicked = {},
                modifier = modifier
            )

            // Disabled input without complementary buttons
            ChatSimpleInput(
                message = "",
                onMessageChanged = {},
                hint = "Type your message (disabled)",
                showComplementaryActionButtons = false,
                enabled = false,
                onSendMessageBtnClicked = {},
                modifier = modifier
            )
        }
    }
}

@Composable
private fun OutlinedChatTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    decorationBoxModifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    var isFocused by rememberSaveable { mutableStateOf(false) }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .heightIn(min = 40.dp, max = 100.dp)
            .surface(RoundedCornerShape(percent = 70), Color.White, BorderStroke(1.dp, color = color_text_200))
            .onFocusChanged { focusState -> isFocused = focusState.isFocused },
        enabled = enabled,
        textStyle = BodyTextStyle.Body16Regular.toTextStyle().copy(color = color_text_500),
        decorationBox = @Composable { innerTextField ->
            Box(
                modifier = decorationBoxModifier.padding(end = 14.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                if (!isFocused && value.isEmpty()) {
                    Text(
                        text = hint,
                        style = BodyTextStyle.Body16Regular.toTextStyle(),
                        color = color_text_300
                    )
                }
                innerTextField()
            }
        }
    )
}
