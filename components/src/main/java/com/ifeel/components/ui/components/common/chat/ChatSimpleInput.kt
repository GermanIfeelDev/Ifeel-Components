package com.ifeel.components.ui.components.common.chat

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
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
import com.ifeel.components.ui.extension.surface
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_background_6
import com.ifeel.components.ui.theme.color_text_200
import com.ifeel.components.ui.theme.color_text_500
import com.ifeel.components.ui.theme.text.BodyTextStyle

@Composable
fun ChatSimpleInput(
    message: String,
    onMessageChanged: (String) -> Unit,
    hint: String,
    onSendMessageBtnClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Divider(color = color_background_6)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(start = 6.dp, end = 12.dp),
        ) {
            OutlinedChatTextField(
                value = message,
                onValueChange = onMessageChanged,
                hint = hint,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 14.dp)
            )

            SendMessageButton(
                onClick = { onSendMessageBtnClicked.invoke(message) }, modifier = Modifier
                    .align(Alignment.Bottom)
                    .padding(
                        start = 6.dp,
                        bottom = 2.dp
                    )
            )
        }
    }
}


@Composable
@Preview
fun ChatSimpleInputPreview() {
    IfeelComponentsTheme {
        var message by rememberSaveable {
            mutableStateOf("")
        }

        ChatSimpleInput(
            message = message,
            onMessageChanged = { message = it },
            hint = "Type your message",
            onSendMessageBtnClicked = {}
        )
    }
}

@Composable
private fun OutlinedChatTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
) {
    var isFocused by rememberSaveable { mutableStateOf(false) }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .heightIn(min = 40.dp, max = 100.dp)
            .surface(RoundedCornerShape(percent = 70), Color.White, BorderStroke(1.dp, color = color_text_200))
            .onFocusChanged { focusState -> isFocused = focusState.isFocused },
        textStyle = BodyTextStyle.Body16Regular.toTextStyle().copy(color = color_text_500),
        decorationBox = @Composable { innerTextField ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 40.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                if (!isFocused && value.isEmpty()) {
                    Text(
                        text = hint,
                        style = BodyTextStyle.Body16Regular.toTextStyle(), color = color_text_500
                    )
                }
                innerTextField()
            }
        }
    )
}
