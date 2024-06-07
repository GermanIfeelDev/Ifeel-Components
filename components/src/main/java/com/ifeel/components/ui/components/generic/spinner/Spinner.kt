package com.ifeel.components.ui.components.generic.spinner

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.extension.crop
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_200
import com.ifeel.components.ui.theme.color_brand_primary_50
import com.ifeel.components.ui.theme.color_brand_primary_600
import com.ifeel.components.ui.theme.color_text_200
import com.ifeel.components.ui.theme.color_text_300
import com.ifeel.components.ui.theme.color_text_400
import com.ifeel.components.ui.theme.color_text_500
import com.ifeel.components.ui.theme.color_text_600
import com.ifeel.components.ui.theme.text.BodyTextStyle
import com.ifeel.components.ui.theme.text.ButtonTextStyle


enum class SpinnerState {
    INITIAL_OPEN, INITIAL_CLOSED, CHOOSE_OPTION_OPEN, CHOOSE_OPTION_CLOSED;
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Spinner(
    title: String,
    hint: String,
    options: Array<String>,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var spinnerState by rememberSaveable { mutableStateOf(SpinnerState.INITIAL_CLOSED) }
    var selectedItem by rememberSaveable { mutableStateOf(hint) }

    Column(modifier = modifier) {
        Text(text = title, style = BodyTextStyle.Body14Regular.toTextStyle())
        ExposedDropdownMenuBox(
            expanded = spinnerState.isOpen(),
            onExpandedChange = { expanded ->
                spinnerState = when {
                    (!expanded && selectedItem == hint) -> SpinnerState.INITIAL_CLOSED
                    (!expanded && selectedItem != hint) -> SpinnerState.CHOOSE_OPTION_CLOSED
                    (expanded && selectedItem == hint) -> SpinnerState.INITIAL_OPEN
                    (expanded && selectedItem != hint) -> SpinnerState.CHOOSE_OPTION_OPEN
                    else -> SpinnerState.INITIAL_CLOSED
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            OutlinedTextField(
                value = if (spinnerState != SpinnerState.INITIAL_OPEN) selectedItem else "",
                onValueChange = {},
                modifier = Modifier.menuAnchor(),
                readOnly = true,
                textStyle = if (spinnerState == SpinnerState.INITIAL_CLOSED) BodyTextStyle.Body16Regular.toTextStyle()
                    .copy(color_text_500) else
                    BodyTextStyle.Body16Regular.toTextStyle(),
                trailingIcon = {
                    SpinnerIcon(spinnerState = spinnerState)
                },
                shape = RoundedCornerShape(6.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = color_brand_primary_50,
                    unfocusedContainerColor = if (spinnerState == SpinnerState.INITIAL_CLOSED) Color.White else color_brand_primary_50,
                    focusedBorderColor = color_brand_primary_600,
                    unfocusedBorderColor = if (spinnerState == SpinnerState.INITIAL_CLOSED) color_text_400 else color_text_300
                )
            )

            ExposedDropdownMenu(
                expanded = spinnerState.isOpen(),
                onDismissRequest = {
                    spinnerState = if (selectedItem == hint) SpinnerState.INITIAL_CLOSED
                    else SpinnerState.CHOOSE_OPTION_CLOSED
                }, modifier = Modifier
                    .crop(vertical = 8.dp) //We cut the top and bottom of the menu because it has a internal padding @link{https://stackoverflow.com/questions/74238933/how-to-remove-dropdownmenus-default-vertical-padding-when-clicking-the-first-it}
                    .background(Color.White)
            ) {
                options.forEach { option ->
                    ExposedDropdownMenuItem(
                        text = option,
                        onClick = {
                            selectedItem = option
                            onOptionSelected(option)
                            spinnerState = SpinnerState.CHOOSE_OPTION_CLOSED
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun SpinnerIcon(spinnerState: SpinnerState, modifier: Modifier = Modifier) {
    val trailingIcon =
        if (spinnerState.isOpen()) R.drawable.collapse_spinner_ic else R.drawable.expand_spinner_ic
    Icon(
        painter = painterResource(trailingIcon),
        contentDescription = null,
        modifier = modifier,
        tint = if (spinnerState.isOpen()) color_brand_primary_600 else color_text_600,
    )
}

@Composable
private fun ExposedDropdownMenuItem(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    DropdownMenuItem(
        text = {
            Column {
                TextButton(
                    onClick = onClick,
                    shape = RoundedCornerShape(0.dp),
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = color_text_600,
                        containerColor = if (isPressed) color_brand_primary_200 else Color.White
                    ),
                ) {
                    Text(text = text, style = ButtonTextStyle.ButtonDefaultRegular.toTextStyle())
                }
                Divider(color = color_text_200)
            }
        },
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues()
    )
}

@Preview(showBackground = true)
@Composable
private fun DropdownExposedMenuPreview() {
    IfeelComponentsTheme {
        var selectedItem by rememberSaveable { mutableStateOf("") }

        Spinner(
            title = "Gender",
            hint = "Choose",
            options = arrayOf("Option 1", "Option 2", "Option 3"),
            onOptionSelected = {
                selectedItem = it
            },
            modifier = Modifier.padding(horizontal = 20.dp)
        )
    }
}

private fun SpinnerState.isOpen() =
    this == SpinnerState.INITIAL_OPEN || this == SpinnerState.CHOOSE_OPTION_OPEN