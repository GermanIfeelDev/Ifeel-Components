package com.ifeel.components.ui.components.common.survey

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_400
import com.ifeel.components.ui.theme.color_text_700
import com.ifeel.components.ui.theme.text.BodyTextStyle

@Composable
internal fun SurveyOptionButton(
    option: SurveyOptionVO,
    onSelectedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val (text, selected, imageUrl) = option
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = { onSelectedChange(!selected) },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed || selected) color_brand_primary_400 else Color.White,
        ),
        interactionSource = interactionSource,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            imageUrl?.let {
                AsyncImage(
                    model = it,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(getSurveyImageColors(isPressedOrSelected = isPressed || selected)),
                    modifier = Modifier.size(40.dp)
                )
            }

            Text(
                text = text,
                style = BodyTextStyle.Body16Regular.toTextStyle().copy(
                    color = if (isPressed || selected) Color.White else color_text_700
                ),
                modifier = imageUrl?.let {
                    Modifier.padding(start = 12.dp).weight(1f)
                } ?: Modifier
            )
        }
    }
}

@Composable
private fun getSurveyImageColors(isPressedOrSelected: Boolean): Color =
    if (isPressedOrSelected) Color.White else color_text_700

@Preview(showBackground = true, backgroundColor = 0xFFE37C67)
@Composable
private fun SurveyButtonPreview() {
    var selected by rememberSaveable {
        mutableStateOf(false)
    }
    IfeelComponentsTheme {
        Column {

            SurveyOptionButton(
                option = SurveyOptionVO(
                    text = "Test",
                    selected = selected,
                ),
                onSelectedChange = { selected = it },
                modifier = Modifier
                    .padding(8.dp)
                    .height(64.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            SurveyOptionButton(
                option = SurveyOptionVO(
                    text = "Test",
                    selected = selected,
                    imageUrl = "https://cdn-icons-png.flaticon.com/512/5650/5650380.png"
                ),
                onSelectedChange = { selected = it },
                modifier = Modifier
                    .padding(8.dp)
                    .height(64.dp),
            )

        }

    }
}