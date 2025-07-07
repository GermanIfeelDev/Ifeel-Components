package com.ifeel.components.ui.components.generic.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.components.generic.button.config.IfeelIconButtonConfig
import com.ifeel.components.ui.components.generic.button.config.IfeelIconButtonShape
import com.ifeel.components.ui.components.generic.button.config.IfeelIconButtonSize
import com.ifeel.components.ui.components.generic.button.config.IfeelIconButtonType
import com.ifeel.components.ui.components.generic.button.config.borderStroke
import com.ifeel.components.ui.components.generic.button.config.getShape
import com.ifeel.components.ui.components.generic.button.config.iconButtonColors
import com.ifeel.components.ui.theme.IfeelComponentsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IfeelIconButton(
    onClick: () -> Unit,
    @DrawableRes drawableRes: Int,
    config: IfeelIconButtonConfig,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        colors = config.iconButtonColors(isPressed),
        shape = config.getShape(),
        contentPadding = PaddingValues(6.dp),
        border = config.borderStroke(isPressed),
        modifier = modifier.size(config.size.dp)
    ) { Icon(painterResource(drawableRes), null) }
}

@Composable
@Preview(showBackground = true)
fun IfeelIconButtonPreview() {
    IfeelComponentsTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            IfeelIconButton(
                onClick = {},
                drawableRes = R.drawable.ic_test_small,
                config = IfeelIconButtonConfig(
                    size = IfeelIconButtonSize.LARGE,
                    type = IfeelIconButtonType.PRIMARY_FILLED,
                    shape = IfeelIconButtonShape.CIRCLE,
                )
            )

            IfeelIconButton(
                onClick = {},
                drawableRes = R.drawable.ic_test_small,
                config = IfeelIconButtonConfig(
                    size = IfeelIconButtonSize.MEDIUM,
                    type = IfeelIconButtonType.PRIMARY_OUTLINED,
                    shape = IfeelIconButtonShape.CIRCLE,
                )
            )

            IfeelIconButton(
                onClick = {},
                drawableRes = R.drawable.ic_test_small,
                config = IfeelIconButtonConfig(
                    size = IfeelIconButtonSize.SMALL,
                    type = IfeelIconButtonType.SECONDARY_FILLED,
                    shape = IfeelIconButtonShape.CIRCLE,
                )
            )

            IfeelIconButton(
                onClick = {},
                drawableRes = R.drawable.ic_test_small,
                config = IfeelIconButtonConfig(
                    size = IfeelIconButtonSize.EXTRA_SMALL,
                    type = IfeelIconButtonType.SECONDARY_OUTLINED,
                    shape = IfeelIconButtonShape.CIRCLE,
                )
            )

            IfeelIconButton(
                onClick = {},
                drawableRes = R.drawable.ic_test_small,
                config = IfeelIconButtonConfig(
                    size = IfeelIconButtonSize.MEDIUM,
                    type = IfeelIconButtonType.GHOST,
                    shape = IfeelIconButtonShape.CIRCLE,
                )
            )
        }
    }
}