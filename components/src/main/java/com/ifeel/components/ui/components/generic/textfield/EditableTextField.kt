package com.ifeel.components.ui.components.generic.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.ui.components.common.text.ErrorText
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_600
import com.ifeel.components.ui.theme.color_text_400
import com.ifeel.components.ui.theme.color_text_500
import com.ifeel.components.ui.theme.text.BodyTextStyle

@Composable
fun EditableTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    label: String? = null,
    errorMessage: String? = null,
) {
    Column(modifier = modifier) {
        if (label != null) Text(
            text = label,
            style = BodyTextStyle.Body14Regular.toTextStyle().copy(color_text_400)
        )
        TextFieldContentPadding(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            textStyle = BodyTextStyle.Body16Regular.toTextStyle().copy(color_text_500),
            isError = isError,
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = color_brand_primary_600,
                unfocusedIndicatorColor = color_text_400,
                errorContainerColor = Color.Transparent,
                cursorColor = color_text_500
            )
        )
        if (isError && errorMessage != null) {
            ErrorText(text = errorMessage)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditableTextFieldPreview() {
    var editableInput by rememberSaveable {
        mutableStateOf("")
    }
    IfeelComponentsTheme {
        EditableTextField(
            value = editableInput, onValueChange = { editableInput = it },
            modifier = Modifier.padding(8.dp),
            label = "Label",
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EditableTextFieldErrorPreview() {
    var editableInput by rememberSaveable {
        mutableStateOf("email.com")
    }
    IfeelComponentsTheme {
        EditableTextField(
            value = editableInput, onValueChange = { editableInput = it },
            modifier = Modifier.padding(8.dp),
            label = "Label",
            isError = true,
            errorMessage = "Formato inválido"
        )
    }
}