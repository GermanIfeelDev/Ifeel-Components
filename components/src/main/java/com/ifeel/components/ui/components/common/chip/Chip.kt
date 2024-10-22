package com.ifeel.components.ui.components.common.chip

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.ui.components.utils.AsyncImageSvg
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_700
import com.ifeel.components.ui.theme.color_text_100
import com.ifeel.components.ui.theme.color_text_300
import com.ifeel.components.ui.theme.color_text_500
import com.ifeel.components.ui.theme.color_text_600
import com.ifeel.components.ui.theme.text.BodyTextStyle

/**
 * Displays a customizable filter chip that allows selection and displays an optional SVG icon.
 *
 * For design details, refer to the [Selfcare Feature Figma Design](https://www.figma.com/design/zN48vKeTN3r7aEMZeeUGvc/01-App-de-usuario-(2023-2024)?node-id=11839-2437&node-type=frame&t=1dYllWdkIo8x2u4V-0).
 *
 * @param text The text label to display on the chip.
 * @param selected Indicates whether the chip is selected.
 * @param onClick Callback invoked when the chip is clicked.
 * @param modifier Modifier for this layout. Defaults to Modifier.
 * @param svgIconUrl Optional URL for an SVG icon to display on the chip.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IfeelFilterChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    svgIconUrl: String? = null,
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = { Text(text, style = BodyTextStyle.Body14Regular.toTextStyle().copy(color = Color.Unspecified)) },
        modifier = modifier,
        leadingIcon = {
            svgIconUrl?.let {
                AsyncImageSvg(
                    url = it,
                    modifier = Modifier.size(16.dp),
                    colorFilter = ColorFilter.tint(if (selected) Color.White else color_text_600),
                )
            }
        },
        shape = RoundedCornerShape(20.dp),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            labelColor = color_text_500,
            iconColor = Color.Unspecified,
            selectedContainerColor = color_brand_primary_700,
            selectedLabelColor = Color.White,
            selectedLeadingIconColor = Color.White,
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = color_text_300,
            selectedBorderColor = Color.Transparent,
        ),
    )
}

/**
 * Displays a suggestion chip with a text label that is disabled and non-interactive.
 *
 * For design details, refer to the [Selfcare Feature Figma Design](https://www.figma.com/design/zN48vKeTN3r7aEMZeeUGvc/01-App-de-usuario-(2023-2024)?node-id=11839-2437&node-type=frame&t=1dYllWdkIo8x2u4V-0).
 *
 * @param text The text label to display on the suggestion chip.
 * @param modifier Modifier for this layout. Defaults to Modifier.
 */
@Composable
internal fun IfeelSuggestionChip(
    text: String,
    modifier: Modifier = Modifier,
) {
    SuggestionChip(
        onClick = {},
        label = { Text(text, style = BodyTextStyle.Body14Regular.toTextStyle().copy(color = Color.Unspecified)) },
        modifier = modifier,
        enabled = false,
        shape = RoundedCornerShape(20.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            disabledContainerColor = color_text_100,
            disabledLabelColor = color_text_600,
        ),
        border = SuggestionChipDefaults.suggestionChipBorder(disabledBorderColor = Color.Transparent),
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
internal fun IfeelChipPreview() {
    var isSelected by rememberSaveable { mutableStateOf(false) }

    IfeelComponentsTheme {
        Column(modifier = Modifier.padding(16.dp)) {

            IfeelFilterChip(
                text = "Filter Chip Without Icon",
                selected = isSelected,
                onClick = { isSelected = !isSelected },
            )

            Spacer(modifier = Modifier.height(16.dp))

            IfeelFilterChip(
                text = "Filter Chip",
                selected = isSelected,
                onClick = { isSelected = !isSelected },
                svgIconUrl = "https://ifeel-media.s3.eu-west-2.amazonaws.com/carousel/relax.svg"
            )

            Spacer(modifier = Modifier.height(16.dp))

            IfeelSuggestionChip(
                text = "Suggestion Chip",
            )
        }
    }
}