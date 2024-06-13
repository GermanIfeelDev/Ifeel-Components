package com.ifeel.ifeelcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifeel.components.R
import com.ifeel.components.ui.components.common.textfield.PasswordTextField
import com.ifeel.components.ui.components.generic.button.ButtonType
import com.ifeel.components.ui.components.generic.button.PrimaryButton
import com.ifeel.components.ui.components.generic.spinner.Spinner
import com.ifeel.components.ui.components.generic.textfield.EditableTextField
import com.ifeel.components.ui.components.generic.textfield.OutlinedTextField
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.recoletaFontFamily
import com.ifeel.components.ui.theme.sofiaProFontFamily
import com.ifeel.components.ui.theme.text.HeadlineTextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IfeelComponentsTheme {
                var showTextComponents by rememberSaveable { mutableStateOf(false) }
                var showInputComponents by rememberSaveable { mutableStateOf(false) }
                var checkboxChecked by rememberSaveable { mutableStateOf(false) }

                Column(modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .horizontalScroll(
                        rememberScrollState()
                    )) {
                    Row {
                        PrimaryButton(
                            text = "See some text with other styles",
                            onClick = { showTextComponents = !showTextComponents })
                        PrimaryButton(
                            text = "Input components",
                            onClick = { showInputComponents = !showInputComponents },
                            buttonType = ButtonType.SECONDARY,
                            contentAlignment = Alignment.End,
                            iconResource = R.drawable.supporting_text_info_ic
                        )

                        Spinner(
                            title = "Spinner",
                            hint = "Choose option",
                            options = arrayOf("Option 1", "Option 2", "Option 3"),
                            onOptionSelected = {}
                        )

                        Checkbox(checked = checkboxChecked, onCheckedChange = {checkboxChecked = it})
                    }
                    if (showTextComponents) {
                        TextComponents()
                    }

                    if (showInputComponents) {
                        InputsComponents()
                    }
                }
            }
        }
    }
}

@Composable
fun TextComponents(modifier: Modifier = Modifier) {
    Column {
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        Text(
            text = "We can create text styles in 3 different ways.\n" +
                    "1. Using the objects in the library, which are based on the Ifeel Figma System\n" +
                    "2. Taking the above, and customizing it with a copy()\n" +
                    "3. Creating a TextStyle from 0 (This would be the most extreme case, the best thing is that if that TextStyle differs a lot from all of them, and is used in several places, the developer is asked to put it in the library)"
        )
        Text(
            text = "1. H2 SemiBold With Default Object",
            style = HeadlineTextStyle.H2SemiBold.toTextStyle(),
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = "2. H2 Semibold With Copy (Changed FontFamily to Recoleta and Font Weight to Medium)",
            style = HeadlineTextStyle.H2SemiBold.toTextStyle().copy(
                fontFamily = recoletaFontFamily, fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = "Text Style fully customized",
            style = TextStyle(
                fontFamily = sofiaProFontFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp
            ),
        )
        Divider(modifier = Modifier.padding(vertical = 8.dp))
    }
}

@Composable
fun InputsComponents(modifier: Modifier = Modifier) {
    var inputValue by rememberSaveable { mutableStateOf("") }

    Column {
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        PasswordTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            supportingText = "Supporting text"
        )
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            label = "Email"
        )
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        EditableTextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            isError = true,
            errorMessage = "Error message"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextComponentsPreview() {
    IfeelComponentsTheme {
        TextComponents()
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentsPreview() {
    IfeelComponentsTheme {
        InputsComponents()
    }
}

