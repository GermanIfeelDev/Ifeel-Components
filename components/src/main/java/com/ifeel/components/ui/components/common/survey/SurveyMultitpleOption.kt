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
import com.ifeel.components.ui.components.common.survey.vo.QuestionMultipleOptionVO
import com.ifeel.components.ui.theme.IfeelComponentsTheme

@Composable
fun SurveyMultipleOption(
    options: List<Pair<String, Boolean>>,
    onOptionSelected: (Pair<String, Boolean>) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(options) { option ->
            SurveyMultipleOptionButton(
                text = option.first,
                selected = option.second,
                onSelectedChange = {
                    onOptionSelected(option.copy(second = it))
                }
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
        SurveyMultipleOption(
            options = options,
            onOptionSelected = { selectedOption ->
                val selectedOptionIndex = options.indexOfFirst { it.first == selectedOption.first }

                if (selectedOptionIndex != -1) {
                    options[selectedOptionIndex] = selectedOption
                }
            }
        )
    }

}


