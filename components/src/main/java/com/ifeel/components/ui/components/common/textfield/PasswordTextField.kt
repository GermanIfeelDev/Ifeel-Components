package com.ifeel.components.ui.components.common.textfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.ifeel.components.R
import com.ifeel.components.ui.components.generic.textfield.OutlinedTextField
import com.ifeel.components.ui.components.generic.textfield.ToogleIcon
import com.ifeel.components.ui.theme.IfeelComponentsTheme

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    inputText: String? = null,
    label: String? = null,
    errorMessage: String? = null,
    supportingText: String? = null,
    enabled: Boolean = true,
) {
    var showInput by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        inputText = inputText,
        label = label,
        errorMessage = errorMessage,
        supportingText = supportingText,
        enabled = enabled,
        isError = isError,
        visualTransformation = if (showInput) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            ToogleIcon(
                activeIcon = ImageVector.vectorResource(R.drawable.hide_input_ic),
                inactiveIcon = ImageVector.vectorResource(R.drawable.show_input_ic),
                checked = showInput,
                onCheckedChange = {
                    showInput = it
                },
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PasswordInputPreview() {
    IfeelComponentsTheme {
        var inputValue by rememberSaveable { mutableStateOf("") }

        PasswordTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = "Password label",
            inputText = "Password Input Text",
            supportingText = "Añadir aquí información para ayudar al usuario a entender este input"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PasswordInputErrorPreview() {
    IfeelComponentsTheme {
        PasswordTextField(
            value = "",
            onValueChange = { },
            isError = true,
            errorMessage = "Formato invalido"
        )
    }
}