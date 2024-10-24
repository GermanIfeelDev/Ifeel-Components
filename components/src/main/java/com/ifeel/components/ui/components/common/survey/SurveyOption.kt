package com.ifeel.components.ui.components.common.survey

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.ui.theme.IfeelComponentsTheme

enum class SurveyType {
    SINGLE, MULTIPLE
}

data class SurveyOptionVO(
    val text: String,
    val selected: Boolean,
    val imageUrl: String? = null,
)

/**
 * Displays a list of survey options as buttons in a vertical list.
 *
 * [Design](https://www.figma.com/design/7GJjL34sYDK9gXPX5RRjmB/Maccabi?node-id=798-13106&t=y1FUdrSyqexAwBMO-4)
 *
 * @param options The list of survey options, each represented by a [SurveyOptionVO].
 * @param onOptionSelected Lambda function invoked when an option is selected or deselected.
 * @param surveyType The type of survey options layout.
 * @param modifier Modifier for this layout. Defaults to Modifier.
 */
@Composable
fun SurveyOption(
    options: List<SurveyOptionVO>,
    onOptionSelected: (Pair<String, Boolean>) -> Unit,
    surveyType: SurveyType,
    modifier: Modifier = Modifier,
) {
    val buttonHeight = if (surveyType == SurveyType.SINGLE) 80.dp else 64.dp
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(options) { option ->
            SurveyOptionButton(
                option = option,
                onSelectedChange = {
                    onOptionSelected(Pair(option.text, it))
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
//    val options = remember {
//        mutableStateListOf(
//            Pair("Option 1", false),
//            Pair("Option 2", false),
//            Pair("Option 3", false)
//        )
//    }
//
//    IfeelComponentsTheme {
//        SurveyOption(
//            options = options,
//            surveyType = SurveyType.MULTIPLE,
//            onOptionSelected = { selectedOption ->
//                val selectedOptionIndex = options.indexOfFirst { it.first == selectedOption.first }
//
//                if (selectedOptionIndex != -1) {
//                    options[selectedOptionIndex] = selectedOption
//                }
//            }
//        )
//    }

}

@Preview(showBackground = true, backgroundColor = 0xFFE37C67)
@Composable
private fun SurveySingleOptionPreview() {
//    val options = remember {
//        mutableStateListOf(
//            Pair("Option 1", false),
//            Pair("Option 2", false),
//            Pair("Option 3", false)
//        )
//    }
//
//    IfeelComponentsTheme {
//        SurveyOption(
//            options = options,
//            surveyType = SurveyType.SINGLE,
//            onOptionSelected = { selectedOption ->
//                //Reset all the options to false
//                for (i in options.indices) {
//                    options[i] = options[i].copy(second = false)
//                }
//
//                val selectedOptionIndex = options.indexOfFirst { it.first == selectedOption.first }
//
//                if (selectedOptionIndex != -1) {
//                    options[selectedOptionIndex] = selectedOption
//                }
//            }
//        )
//    }

}


