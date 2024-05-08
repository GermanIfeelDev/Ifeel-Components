package com.ifeel.components.ui.components.generic.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
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
import com.ifeel.components.ui.theme.color_brand_primary_200
import com.ifeel.components.ui.theme.color_brand_primary_600
import com.ifeel.components.ui.theme.color_brand_primary_700
import com.ifeel.components.ui.theme.color_brand_secondary_200
import com.ifeel.components.ui.theme.color_brand_secondary_400
import com.ifeel.components.ui.theme.color_brand_secondary_600
import com.ifeel.components.ui.theme.text.ButtonTextStyle

enum class ButtonType {
    PRIMARY,
    SECONDARY
}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes iconResource: Int? = null,
    contentAlignment: Alignment.Horizontal = Alignment.Start,
    isEnabled: Boolean = true,
    buttonType: ButtonType = ButtonType.PRIMARY
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = onClick,
        modifier = modifier
            .defaultMinSize(minWidth = 180.dp),
        enabled = isEnabled,
        shape = RoundedCornerShape(6.dp),
        colors = getButtonColors(buttonType, isPressed),
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
private fun getButtonColors(buttonType: ButtonType, isPressed: Boolean): ButtonColors {
    val containerColor = when (buttonType) {
        ButtonType.PRIMARY -> if (isPressed) color_brand_primary_700 else color_brand_primary_600
        ButtonType.SECONDARY -> if (isPressed) color_brand_secondary_600 else color_brand_secondary_400
    }

    val disabledContainerColor = when (buttonType) {
        ButtonType.PRIMARY -> color_brand_primary_200
        ButtonType.SECONDARY -> color_brand_secondary_200
    }

    return ButtonDefaults.buttonColors(
        containerColor = containerColor,
        disabledContainerColor = disabledContainerColor,
        contentColor = Color.White,
        disabledContentColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreviewEnabled() {
    IfeelComponentsTheme {
        PrimaryButton(
            text = "Add",
            onClick = { },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            iconResource = R.drawable.supporting_text_info_ic,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreviewDisabled() {
    IfeelComponentsTheme {
        PrimaryButton(
            text = "Disabled",
            onClick = { },
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp),
            isEnabled = false,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreviewColorAccent() {
    IfeelComponentsTheme {
        PrimaryButton(
            text = "Disabled",
            onClick = { },
            iconResource = R.drawable.supporting_text_info_ic,
            contentAlignment = Alignment.End,
            buttonType = ButtonType.SECONDARY
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreviewColorAccentDisabled() {
    IfeelComponentsTheme {
        PrimaryButton(
            text = "Disabled",
            onClick = { },
            iconResource = R.drawable.supporting_text_info_ic,
            contentAlignment = Alignment.End,
            isEnabled = false,
            buttonType = ButtonType.SECONDARY
        )
    }
}

