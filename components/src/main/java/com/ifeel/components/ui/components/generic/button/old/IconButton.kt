package com.ifeel.components.ui.components.generic.button.old

import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.components.generic.button.old.config.IconButtonSize
import com.ifeel.components.ui.components.generic.button.old.config.IconButtonType
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_200
import com.ifeel.components.ui.theme.color_brand_primary_600
import com.ifeel.components.ui.theme.color_brand_primary_700
import com.ifeel.components.ui.theme.color_brand_primary_light_200
import com.ifeel.components.ui.theme.color_text_300

@Deprecated("Use new design system icons in IfeelIconButton, this will be removed in the future")
@Composable
fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes resourceId: Int = R.drawable.primary_button_ic,
    enabled: Boolean = true,
    size: IconButtonSize = IconButtonSize.BIG,
    type: IconButtonType = IconButtonType.PRIMARY,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    IconButton(
        onClick = onClick,
        interactionSource = interactionSource,
        colors = getButtonColors(isPressed = isPressed, type = type),
        enabled = enabled,
        modifier = modifier.size(size.dp)
    ) {
        Icon(
            painter = painterResource(id = resourceId),
            contentDescription = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun IconPrimaryButtonPreview() {
    Column {
        IfeelComponentsTheme {
            IconButton(onClick = {}, modifier = Modifier.padding(8.dp))
            IconButton(onClick = {}, enabled = false, modifier = Modifier.padding(8.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun IconSecondaryButtonPreview() {
    Column {
        IfeelComponentsTheme {
            IconButton(
                onClick = {},
                type = IconButtonType.SECONDARY,
                modifier = Modifier.padding(8.dp),
                resourceId = R.drawable.attachment_ic,
            )

            IconButton(
                onClick = {},
                enabled = false,
                type = IconButtonType.SECONDARY,
                modifier = Modifier.padding(8.dp),
                resourceId = R.drawable.attachment_ic,
            )
        }
    }
}

@Composable
private fun getButtonColors(isPressed: Boolean, type: IconButtonType): IconButtonColors {
    val containerColor = when (type) {
        IconButtonType.PRIMARY -> if (isPressed) color_brand_primary_700 else color_brand_primary_600
        IconButtonType.SECONDARY -> if (isPressed) color_brand_primary_light_200 else Color.Transparent
    }
    val disabledContainerColor = when (type) {
        IconButtonType.PRIMARY -> color_brand_primary_200
        IconButtonType.SECONDARY -> Color.Transparent
    }
    val contentColor = when (type) {
        IconButtonType.PRIMARY -> Color.White
        IconButtonType.SECONDARY -> Color.Unspecified
    }

    val disabledContentColor = when (type) {
        IconButtonType.PRIMARY -> Color.White
        IconButtonType.SECONDARY -> color_text_300
    }

    return IconButtonDefaults.iconButtonColors(
        containerColor = containerColor,
        disabledContainerColor = disabledContainerColor,
        contentColor = contentColor,
        disabledContentColor = disabledContentColor
    )
}