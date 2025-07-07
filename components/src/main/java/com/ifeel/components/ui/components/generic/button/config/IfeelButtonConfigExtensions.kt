package com.ifeel.components.ui.components.generic.button.config

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.ifeel.components.ui.theme.color_brand_primary_700
import com.ifeel.components.ui.theme.color_brand_secondary_600
import com.ifeel.components.ui.theme.color_text_400

@Composable
fun IfeelIconButtonConfig.iconButtonColors(isPressed: Boolean) = ButtonDefaults.buttonColors(
    containerColor = if (isPressed) getPressedContainerColor() else getDefaultContainerColor(),
    contentColor = getIconColor(isPressed),
    disabledContainerColor = getDisabledContainerColor(),
    disabledContentColor = getDisabledContentColor()
)

fun IfeelIconButtonConfig.getIconColor(isPressed: Boolean) =
    if (isPressed) getPressedContentColor() else getDefaultContentColor()

@Composable
fun IfeelIconButtonConfig.borderStroke(isPressed: Boolean): BorderStroke? {
    val borderColor = when (type) {
        IfeelIconButtonType.PRIMARY_FILLED, IfeelIconButtonType.SECONDARY_FILLED, IfeelIconButtonType.GHOST -> null
        IfeelIconButtonType.PRIMARY_OUTLINED -> if (isPressed) color_brand_primary_700 else color_text_400
        IfeelIconButtonType.SECONDARY_OUTLINED -> if (isPressed) color_brand_secondary_600 else color_text_400
    }

    return borderColor?.let { BorderStroke(1.dp, it) }
}