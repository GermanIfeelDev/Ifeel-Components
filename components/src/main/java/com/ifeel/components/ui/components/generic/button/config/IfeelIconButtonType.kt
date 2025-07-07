package com.ifeel.components.ui.components.generic.button.config

import androidx.compose.ui.graphics.Color
import com.ifeel.components.ui.theme.color_brand_primary_50
import com.ifeel.components.ui.theme.color_brand_primary_600
import com.ifeel.components.ui.theme.color_brand_primary_700
import com.ifeel.components.ui.theme.color_brand_primary_800
import com.ifeel.components.ui.theme.color_brand_primary_light_300
import com.ifeel.components.ui.theme.color_brand_salmon_300
import com.ifeel.components.ui.theme.color_brand_secondary_400
import com.ifeel.components.ui.theme.color_brand_secondary_600
import com.ifeel.components.ui.theme.color_text_700

enum class IfeelIconButtonType {
    PRIMARY_FILLED, PRIMARY_OUTLINED, SECONDARY_FILLED, SECONDARY_OUTLINED, GHOST;
}

//region Container color
internal fun IfeelIconButtonConfig.getDefaultContainerColor(): Color = when (type) {
    IfeelIconButtonType.PRIMARY_FILLED -> color_brand_primary_700
    IfeelIconButtonType.PRIMARY_OUTLINED, IfeelIconButtonType.SECONDARY_OUTLINED -> Color.White
    IfeelIconButtonType.SECONDARY_FILLED -> color_brand_secondary_600
    IfeelIconButtonType.GHOST -> Color.Transparent
}

internal fun IfeelIconButtonConfig.getPressedContainerColor(): Color = when (type) {
    IfeelIconButtonType.PRIMARY_FILLED -> color_brand_primary_800
    IfeelIconButtonType.PRIMARY_OUTLINED -> color_brand_primary_50
    IfeelIconButtonType.SECONDARY_FILLED -> color_brand_secondary_600
    IfeelIconButtonType.SECONDARY_OUTLINED -> color_brand_salmon_300
    IfeelIconButtonType.GHOST -> color_brand_primary_50
}

internal fun IfeelIconButtonConfig.getDisabledContainerColor(): Color = when (type) {
    IfeelIconButtonType.PRIMARY_FILLED -> color_brand_primary_700.copy(alpha = 0.5f)
    IfeelIconButtonType.PRIMARY_OUTLINED, IfeelIconButtonType.SECONDARY_OUTLINED, IfeelIconButtonType.GHOST -> Color.White
    IfeelIconButtonType.SECONDARY_FILLED -> color_brand_secondary_600.copy(alpha = 0.5f)
}
//endregion

//region Content Color
internal fun IfeelIconButtonConfig.getDefaultContentColor(): Color = when (type) {
    IfeelIconButtonType.PRIMARY_FILLED -> Color.White
    IfeelIconButtonType.PRIMARY_OUTLINED -> color_brand_primary_700
    IfeelIconButtonType.SECONDARY_FILLED -> color_text_700
    IfeelIconButtonType.SECONDARY_OUTLINED -> color_brand_secondary_600
    IfeelIconButtonType.GHOST -> color_text_700
}

internal fun IfeelIconButtonConfig.getPressedContentColor(): Color = when (type) {
    IfeelIconButtonType.PRIMARY_FILLED, IfeelIconButtonType.SECONDARY_FILLED -> Color.White
    IfeelIconButtonType.PRIMARY_OUTLINED -> color_brand_primary_700
    IfeelIconButtonType.SECONDARY_OUTLINED -> color_brand_secondary_600
    IfeelIconButtonType.GHOST -> color_brand_primary_600
}

internal fun IfeelIconButtonConfig.getDisabledContentColor() = when (type) {
    IfeelIconButtonType.PRIMARY_FILLED, IfeelIconButtonType.SECONDARY_FILLED -> Color.White
    IfeelIconButtonType.PRIMARY_OUTLINED, IfeelIconButtonType.GHOST -> color_brand_primary_light_300.copy(alpha = 0.5f)
    IfeelIconButtonType.SECONDARY_OUTLINED -> color_brand_secondary_400.copy(alpha = 0.5f)
}
//endregion