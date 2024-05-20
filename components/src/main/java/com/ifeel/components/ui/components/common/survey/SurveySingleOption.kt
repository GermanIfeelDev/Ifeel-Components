package com.ifeel.components.ui.components.common.survey

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.ui.theme.IfeelComponentsTheme

@Composable
fun SurveySingleOption(
    options: List<String>,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(options) { option ->
            SurveySingleOptionButton(
                text = option,
                onClick = { onOptionSelected(option) }
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFE37C67)
@Composable
private fun SurveySingleOptionPreview() {
    val options = remember {
        mutableStateListOf("Option 1", "Option 2", "Option 3")
    }

    IfeelComponentsTheme {
        SurveySingleOption(
            options = options,
            onOptionSelected = { selectedOption ->
                val selectedOptionIndex = options.indexOfFirst { it == selectedOption }

                if (selectedOptionIndex != -1) {
                    options[selectedOptionIndex] = selectedOption
                }
            }
        )
    }

}

