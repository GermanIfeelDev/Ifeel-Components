package com.ifeel.components.ui.components.common.survey

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.components.generic.button.PrimaryButton
import com.ifeel.components.ui.extension.surface
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_text_400
import com.ifeel.components.ui.theme.color_text_600
import com.ifeel.components.ui.theme.text.BodyTextStyle
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

private const val SURVEY_AGE_OPTION_HINT = "DD/MM/YYYY"
private const val AGE_INPUT_SIZE_WIDE = 64

@Composable
fun SurveyAgeOption(
    hintText: String = SURVEY_AGE_OPTION_HINT,
    value: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Box(
        modifier = modifier
            .height(AGE_INPUT_SIZE_WIDE.dp)
            .fillMaxWidth()
            .surface(RoundedCornerShape(size = 6.dp), Color.White, BorderStroke(1.dp, color_text_400))
            .clickable(onClick = onClick)
    ) {
        Text(
            text = value ?: hintText,
            style = BodyTextStyle.Body16Regular.toTextStyle().copy(color = if (value == hintText) color_text_400 else color_text_600),
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 12.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.open_calendar_ic),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp)
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, backgroundColor = 0xFFE37C67)
@Composable
private fun SurveyAgeOptionPreview() {
    IfeelComponentsTheme {
        var currentDate: String? by rememberSaveable { mutableStateOf(null) }
        var isError by rememberSaveable { mutableStateOf(false) }

        Column(modifier = Modifier.padding(horizontal = 8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            SurveyAgeOption(
                value = currentDate,
                onClick = {
                    currentDate = "03/12/2022"
                }
            )

            PrimaryButton(text = "Validar", onClick = {
                isError = !isValidDate(currentDate)
            })
        }

    }

}

@RequiresApi(Build.VERSION_CODES.O)
private fun isValidDate(date: String?): Boolean {
    // Define the expected date format: DD/MM/YYYY
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    return try {
        // Try to parse the date using the specified format
        val parsedDate = LocalDate.parse(date, formatter)
        true // If parsing is successful, the date is valid
    } catch (e: DateTimeParseException) {
        false // If a parsing error occurs, the date is invalid
    }
}

