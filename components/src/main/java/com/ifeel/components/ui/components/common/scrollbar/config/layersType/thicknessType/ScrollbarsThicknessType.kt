package com.ifeel.components.ui.components.common.scrollbar.config.layersType.thicknessType

import androidx.compose.ui.unit.Dp
import com.ifeel.components.ui.components.common.scrollbar.config.ScrollbarsOrientation
import com.ifeel.components.ui.components.common.scrollbar.config.layercontenttype.ScrollbarsLayerContentType
import com.ifeel.components.ui.components.common.scrollbar.config.layersType.ScrollbarsLayersType
import com.ifeel.components.ui.components.common.scrollbar.config.layersType.layerConfig.ScrollbarsLayerConfig

/**
 * The scrollbars thickness type configuration for knob and/or background [ScrollbarsLayersType].
 *
 * @see ScrollbarsLayerConfig
 * @see ScrollbarsOrientation
 */
sealed interface ScrollbarsThicknessType {

    /**
     * The exact scrollbars thickness size (width or height, depends on [ScrollbarsOrientation]).
     *
     * @property thickness The exact thickness size.
     */
    data class Exact(
        val thickness: Dp = ScrollbarsThicknessTypeDefaults.Exact.Thickness
    ) : ScrollbarsThicknessType

    /**
     * The wrap content scrollbars thickness size (width or height, depends on [ScrollbarsOrientation]).
     *
     * Basically, it is only used for a [ScrollbarsLayerContentType.Custom], so it is possible to have a dynamic thickness size.
     */
    data object Wrap : ScrollbarsThicknessType
}