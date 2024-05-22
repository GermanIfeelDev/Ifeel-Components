package com.ifeel.components.ui.components.generic.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_200
import com.ifeel.components.ui.theme.color_brand_primary_600
import com.ifeel.components.ui.theme.color_brand_primary_700

@Composable
fun IconPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        colors = getButtonColors(isPressed = isPressed),
        enabled = enabled,
        modifier = modifier.size(44.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.primary_button_ic),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterVertically)
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
private fun getButtonColors(isPressed: Boolean): ButtonColors {
    val containerColor = if (isPressed) color_brand_primary_700 else color_brand_primary_600

    return ButtonDefaults.buttonColors(
        containerColor = containerColor,
        disabledContainerColor = color_brand_primary_200,
        contentColor = Color.White,
        disabledContentColor = Color.White
    )
}