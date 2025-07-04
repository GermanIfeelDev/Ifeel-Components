package com.ifeel.components.ui.components.common.chat

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ifeel.components.R
import com.ifeel.components.ui.components.generic.button.IconButton
import com.ifeel.components.ui.components.generic.button.config.IconButtonSize
import com.ifeel.components.ui.components.generic.button.config.IconButtonType

@Composable
internal fun AttachmentButton(
    onClick: () -> Unit,
    isEnabled: Boolean,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
        resourceId = R.drawable.attachment_ic,
        modifier = modifier,
        size = IconButtonSize.MEDIUM,
        type = IconButtonType.SECONDARY,
        enabled = isEnabled,
    )
}