package com.ifeel.components.ui.components.generic.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_100
import com.ifeel.components.ui.theme.color_brand_primary_700
import com.ifeel.components.ui.theme.color_text_300
import com.ifeel.components.ui.theme.color_white
import com.ifeel.components.ui.theme.text.ButtonTextStyle

@Composable
fun OutlineButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes iconResource: Int? = null,
    contentAlignment: Alignment.Horizontal = Alignment.Start,
    isEnabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = onClick,
        modifier = modifier
            .defaultMinSize(minWidth = 180.dp)
            .height(44.dp),
        enabled = isEnabled,
        shape = RoundedCornerShape(6.dp),
        colors = getButtonColors(isPressed),
        border = BorderStroke(1.dp, getBorderColor(isEnabled)),
        interactionSource = interactionSource,
    ) {
        TextWithIcon(text = text, iconResource = iconResource, contentAlignment = contentAlignment)
    }
}

@Composable
private fun TextWithIcon(
    text: String,
    @DrawableRes iconResource: Int? = null,
    contentAlignment: Alignment.Horizontal = Alignment.Start
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        when (contentAlignment) {
            Alignment.Start -> {
                if (iconResource != null) Icon(imageVector = ImageVector.vectorResource(id = iconResource), contentDescription = null, tint = Color.Unspecified)
                Text(
                    text = text,
                    style = ButtonTextStyle.ButtonDefaultSemiBold.toTextStyle()
                )
            }

            Alignment.End -> {
                Text(
                    text = text,
                    style = ButtonTextStyle.ButtonDefaultSemiBold.toTextStyle()
                )
                if (iconResource != null) Icon(imageVector = ImageVector.vectorResource(id = iconResource), contentDescription = null, tint = Color.Unspecified)
            }
        }
    }
}

@Composable
private fun getBorderColor(isEnabled: Boolean): Color {
    return if(isEnabled) color_brand_primary_700 else color_text_300
}

@Composable
private fun getButtonColors(isPressed: Boolean): ButtonColors {
    val containerColor = if (isPressed) color_brand_primary_100 else color_white

    val disabledContainerColor = color_white

    return ButtonDefaults.buttonColors(
        containerColor = containerColor,
        disabledContainerColor = disabledContainerColor,
        contentColor = color_brand_primary_700,
        disabledContentColor = color_text_300
    )
}

@Preview(showBackground = true)
@Composable
private fun OutlineButtonPreviewEnabled() {
    IfeelComponentsTheme {
        OutlineButton(
            text = "Add",
            onClick = { },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            iconResource = R.drawable.supporting_text_info_ic,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OutlineButtonPreviewDisabled() {
    IfeelComponentsTheme {
        OutlineButton(
            text = "Disabled",
            onClick = { },
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp),
            isEnabled = false,
        )
    }
}


