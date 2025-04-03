package com.ifeel.components.ui.components.common.scrollbar.config.layercontenttype.layercontentstyletype

import androidx.compose.ui.unit.Dp
import com.ifeel.components.ui.components.common.scrollbar.config.layercontenttype.ScrollbarsLayerContentType

/**
 * The scrollbars layer content style configuration for [ScrollbarsLayerContentType.Default].
 *
 * @see ScrollbarsLayerContentType
 */
sealed interface ScrollbarsLayerContentStyleType {

    /** The background layer content style. */
    data object Background : ScrollbarsLayerContentStyleType

    /**
     * The outline border layer content style.
     *
     * @property width The border width.
     */
    data class Border(
        val width: Dp = ScrollbarsLayerContentStyleTypeDefaults.Border.Width
    ) : ScrollbarsLayerContentStyleType
}