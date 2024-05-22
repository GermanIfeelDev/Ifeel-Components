package com.ifeel.components.ui.components.common.survey

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.ui.theme.IfeelComponentsTheme

enum class SurveyType {
    SINGLE, MULTIPLE
}
@Composable
fun SurveyOption(
    options: List<Pair<String, Boolean>>,
    onOptionSelected: (Pair<String, Boolean>) -> Unit,
    surveyType: SurveyType,
    modifier: Modifier = Modifier
) {
    val buttonHeight = if (surveyType == SurveyType.SINGLE) 80.dp else 64.dp
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        options.forEach {option ->
            SurveyOptionButton(
                text = option.first,
                selected = option.second,
                onSelectedChange = {
                    onOptionSelected(option.copy(second = it))
                },
                modifier = Modifier
                    .height(buttonHeight)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFE37C67)
@Composable
private fun SurveyMultipleOptionPreview() {
    val options = remember {
        mutableStateListOf(Pair("Option 1", false), Pair("Option 2", false), Pair("Option 3", false))
    }

    IfeelComponentsTheme {
        SurveyOption(
            options = options,
            surveyType = SurveyType.MULTIPLE,
            onOptionSelected = { selectedOption ->
                val selectedOptionIndex = options.indexOfFirst { it.first == selectedOption.first }

                if (selectedOptionIndex != -1) {
                    options[selectedOptionIndex] = selectedOption
                }
            }
        )
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFE37C67)
@Composable
private fun SurveySingleOptionPreview() {
    val options = remember {
        mutableStateListOf(Pair("Option 1", false), Pair("Option 2", false), Pair("Option 3", false))
    }

    IfeelComponentsTheme {
        SurveyOption(
            options = options,
            surveyType = SurveyType.SINGLE,
            onOptionSelected = { selectedOption ->
                //Reset all the options to false
                for (i in options.indices) {
                    options[i] = options[i].copy(second = false)
                }

                val selectedOptionIndex = options.indexOfFirst { it.first == selectedOption.first }

                if (selectedOptionIndex != -1) {
                    options[selectedOptionIndex] = selectedOption
                }
            }
        )
    }

}


