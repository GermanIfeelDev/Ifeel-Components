package com.ifeel.components.ui.components.common.survey

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_100
import com.ifeel.components.ui.theme.color_brand_primary_600

/**
 * Displays a step progress bar composed of individual steps.
 *
 * [Design](https://www.figma.com/design/7GJjL34sYDK9gXPX5RRjmB/Maccabi?node-id=798-13118&t=y1FUdrSyqexAwBMO-4)
 *
 * @param totalProgress The total number of steps in the progress bar.
 * @param currentProgress The current progress, indicating how many steps are enabled.
 * @param modifier Modifier for this layout. Defaults to Modifier.
 */
@Composable
fun StepProgressBar(totalProgress: Int, currentProgress: Int, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = modifier.fillMaxWidth()) {
        for (i in 1..totalProgress) {
            StepProgress(enabled = currentProgress >= i, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun StepProgress(enabled: Boolean, modifier: Modifier = Modifier) {
    val color = if (enabled) color_brand_primary_600 else color_brand_primary_100
    Divider(
        color = color, thickness = 4.dp, modifier = modifier
            .wrapContentWidth()
            .clip(
                RoundedCornerShape(4.dp)
            )
    )
}


@Preview(showBackground = true, backgroundColor = 0xFFE37C67)
@Composable
private fun StepProgressBarPreview() {
    val totalProgress = 5
    var currentProgress by rememberSaveable {
        mutableIntStateOf(1)
    }

    IfeelComponentsTheme {
        Column {
            StepProgressBar(
                totalProgress = totalProgress,
                currentProgress = currentProgress,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Button(onClick = { if ( currentProgress != totalProgress) currentProgress++ }) {
                Text(text = "Increase")
            }

            Button(onClick = { if ( currentProgress != 1) currentProgress-- }) {
                Text(text = "Decrease")
            }

        }
    }


}