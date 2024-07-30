package com.ifeel.components.ui.components.common.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ifeel.components.R
import com.ifeel.components.ui.theme.color_brand_primary_800
import com.ifeel.components.ui.theme.text.CaptionTextStyle

/**
 * A composable function that displays a tooltip with text. The tooltip consists of a text box with rounded corners
 * and a polygon icon below it.
 *
 * @param text The text to be displayed inside the tooltip.
 * @param modifier The modifier to be applied to the ConstraintLayout that contains the tooltip components.
 */
@Composable
fun ToolTipText(text: String, modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (tooltipPolygon, tooltipText) = createRefs()

        Text(
            text = text,
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(color_brand_primary_800)
                .padding(8.dp)
                .constrainAs(tooltipText) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            style = CaptionTextStyle.Caption12Regular.toTextStyle().copy(color = Color.White)
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.tooltip_polygion_ic),
            contentDescription = null,
            modifier = Modifier.constrainAs(tooltipPolygon) {
                end.linkTo(tooltipText.end, margin = 18.dp)
                top.linkTo(tooltipText.bottom, margin = (-6).dp)
            },
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ToolTipTextPreview() {
    ToolTipText(
        text = "¿Need help? Contact Customer Support",
        modifier = Modifier.padding(12.dp)
    )
}