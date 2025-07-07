package com.ifeel.components.ui.components.generic.button.config

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

enum class IfeelIconButtonShape() {
    CIRCLE, SQUARE;
}

fun IfeelIconButtonConfig.getShape() = when (shape) {
    IfeelIconButtonShape.CIRCLE -> CircleShape
    IfeelIconButtonShape.SQUARE -> RoundedCornerShape(6.dp)
}
