package com.ifeel.components.ui.components.common.button

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.KeyframesSpec
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.components.common.text.ToolTipText
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_800
import kotlinx.coroutines.delay

private const val ANIMATION_DURATION = 300

/**
 * A composable function that displays a WhatsApp button with an optional tooltip. The button and tooltip appear
 * with a delay and fade in/out animations.
 *
 * @param onClick The callback to be invoked when the button is clicked.
 * @param descriptionText The text to be displayed in the tooltip.
 * @param modifier The modifier to be applied to the Column that contains the button and tooltip.
 */
@Composable
fun WhatsappButtonWithTooltip(onClick: () -> Unit, descriptionText: String, modifier: Modifier = Modifier) {
    var showWhatsappBtn by rememberSaveable {
        mutableStateOf(false)
    }
    var showTooltipText by rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        showWhatsappBtn = true
    }
    LaunchedEffect(key1 = Unit) {
        delay(3000)
        showTooltipText = true
        delay(3000)
        showTooltipText = false
    }

    AnimatedVisibility(visible = showWhatsappBtn, enter = fadeIn(animationSpec = getAnimationSpec()), exit = fadeOut(animationSpec = getAnimationSpec()), modifier = modifier) {
        Column(horizontalAlignment = Alignment.Start) {
            AnimatedVisibility(visible = showTooltipText, enter = fadeIn(animationSpec = getAnimationSpec()), exit = fadeOut(animationSpec = getAnimationSpec())) {
                if (showTooltipText) {
                    ToolTipText(descriptionText)
                }
            }

            if (showWhatsappBtn) {
                WhatsappButton(onClick = onClick, modifier = Modifier.padding(top = 8.dp))
            }
        }

    }
}

private fun getAnimationSpec(): KeyframesSpec<Float> = keyframes {
    this.durationMillis = ANIMATION_DURATION
}

/**
 * A composable function that displays a WhatsApp button with a specific style.
 *
 * @param onClick The callback to be invoked when the button is clicked.
 * @param modifier The modifier to be applied to the Button.
 */
@Composable
fun WhatsappButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.size(48.dp),
        shape = RoundedCornerShape(topEnd = 24.dp, bottomEnd = 24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color_brand_primary_800
        ),
        contentPadding = PaddingValues()
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(id = R.drawable.whatsapp_phone_ic),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Icon(
                painter = painterResource(id = R.drawable.whatsapp_circle_ic),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun WhatsappButtonPreview() {
    IfeelComponentsTheme {
        WhatsappButton(onClick = {}, modifier = Modifier.padding(12.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun WhatsappButtonTooltipPreview() {
    IfeelComponentsTheme {
        WhatsappButtonWithTooltip(
            onClick = {},
            descriptionText = "¿Need help? Contact Customer Support",
            modifier = Modifier.padding(12.dp)
        )
    }
}