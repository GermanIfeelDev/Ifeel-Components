package com.ifeel.components.ui.components.common.scrollbar.config.layersType.layerConfig

import androidx.compose.foundation.layout.PaddingValues
import com.ifeel.components.ui.components.common.scrollbar.config.layersType.ScrollbarsLayersType
import com.ifeel.components.ui.components.common.scrollbar.config.layersType.thicknessType.ScrollbarsThicknessType

/**
 * The default values for [ScrollbarsLayerConfig].
 *
 * @see ScrollbarsLayersType.Split
 */
object ScrollbarsLayerConfigDefaults {

    /** The default scrollbars layer [ScrollbarsThicknessType]. */
    val ThicknessType: ScrollbarsThicknessType = ScrollbarsThicknessType.Exact()

    /** The default [ScrollbarsLayerGravity]. */
    val Gravity: ScrollbarsLayerGravity = ScrollbarsLayerGravity.Center

    /** The default scrollbars layer [PaddingValues]. */
    val PaddingValues: PaddingValues = PaddingValues()
}