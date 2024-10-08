package com.ifeel.components.ui.components.generic.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_200
import com.ifeel.components.ui.theme.color_brand_primary_600
import com.ifeel.components.ui.theme.color_brand_primary_700

enum class IconPrimaryButtonSize(val dp: Dp) {
    SMALL(24.dp), MEDIUM(34.dp), BIG(44.dp)
}

@Composable
fun IconPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes resourceId: Int = R.drawable.primary_button_ic,
    enabled: Boolean = true,
    size: IconPrimaryButtonSize = IconPrimaryButtonSize.BIG
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    IconButton(
        onClick = onClick,
        interactionSource = interactionSource,
        colors = getButtonColors(isPressed = isPressed),
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
    IfeelComponentsTheme {
        IconPrimaryButton(onClick = {}, modifier = Modifier.padding(8.dp))
    }
}

@Composable
private fun getButtonColors(isPressed: Boolean): IconButtonColors {
    val containerColor = if (isPressed) color_brand_primary_700 else color_brand_primary_600

    return IconButtonDefaults.iconButtonColors(
        containerColor = containerColor,
        disabledContainerColor = color_brand_primary_200,
        contentColor = Color.White,
        disabledContentColor = Color.White
    )
}