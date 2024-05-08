package com.ifeel.components.ui.components.generic.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifeel.components.R
import com.ifeel.components.ui.components.common.text.ErrorText
import com.ifeel.components.ui.theme.color_brand_primary_600
import com.ifeel.components.ui.theme.color_danger_500
import com.ifeel.components.ui.theme.color_text_300
import com.ifeel.components.ui.theme.color_text_400
import com.ifeel.components.ui.theme.color_text_500
import com.ifeel.components.ui.theme.color_text_600
import com.ifeel.components.ui.theme.color_text_700
import com.ifeel.components.ui.theme.text.BodyTextStyle

@Composable
fun OutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    inputText: String? = null,
    label: String? = null,
    errorMessage: String? = null,
    enabled: Boolean = true,
    isFocused: Boolean = false,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onFocusChanged: (FocusState) -> Unit = {},
    supportingText: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    Column(modifier = modifier) {
        if (label != null) {
            Text(
                text = label,
                style = BodyTextStyle.Body14Regular.toTextStyle().copy(color = color_text_400)
            )
        }
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .onFocusChanged { onFocusChanged.invoke(it) },
            trailingIcon = trailingIcon,
            singleLine = true,
            isError = isError,
            enabled = enabled,
            textStyle = LocalTextStyle.current.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                lineHeight = 24.sp,
            ),
            label = {
                if (!isFocused && inputText != null) {
                    Text(
                        text = inputText,
                        style = BodyTextStyle.Body16Regular.toTextStyle()
                            .copy(color = color_text_400)
                    )
                }
            },
            visualTransformation = visualTransformation,
            shape = RoundedCornerShape(6.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = color_text_700,
                unfocusedTextColor = color_text_700,
                focusedBorderColor = color_brand_primary_600,
                unfocusedBorderColor = if (value.isNotBlank()) color_text_600 else color_text_300,
                cursorColor = color_text_700,
                errorBorderColor = color_danger_500
            )
        )
        supportingText?.invoke()
        if (isError && errorMessage != null) {
            ErrorText(text = errorMessage)
        }
    }
}

@Composable
internal fun TextFieldSupportingText(text: String, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(top = 8.dp)) {
        Icon(
            ImageVector.vectorResource(R.drawable.supporting_text_info_ic),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, end = 12.dp)
        )
        Text(
            text = text,
            style = BodyTextStyle.Body14Regular.toTextStyle().copy(color = color_text_500),
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
        )
    }
}

@Composable
internal fun ToogleIcon(
    activeIcon: ImageVector,
    inactiveIcon: ImageVector,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    IconToggleButton(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (checked) activeIcon else inactiveIcon,
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}
