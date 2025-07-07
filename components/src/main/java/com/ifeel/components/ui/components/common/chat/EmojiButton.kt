package com.ifeel.components.ui.components.common.chat

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ifeel.components.R
import com.ifeel.components.ui.components.generic.button.old.IconButton
import com.ifeel.components.ui.components.generic.button.old.config.IconButtonSize
import com.ifeel.components.ui.components.generic.button.old.config.IconButtonType

@Composable
internal fun EmojiButton(
    onClick: () -> Unit,
    isEnabled: Boolean,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
        resourceId = R.drawable.emoji_ic,
        modifier = modifier,
        size = IconButtonSize.MEDIUM,
        type = IconButtonType.SECONDARY,
        enabled = isEnabled,
    )
}