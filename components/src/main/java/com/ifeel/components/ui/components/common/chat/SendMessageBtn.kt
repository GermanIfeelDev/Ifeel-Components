package com.ifeel.components.ui.components.common.chat

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.components.generic.button.old.IconButton

@Composable
internal fun SendMessageButton(
    onClick: () -> Unit,
    isEnabled: Boolean,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
        enabled = isEnabled,
        resourceId = R.drawable.send_message_ic,
        modifier = modifier.size(34.dp)
    )
}