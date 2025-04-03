package com.ifeel.components.ui.components.common.scrollbar.config.layersType.layerConfig

import androidx.compose.foundation.layout.PaddingValues
import com.ifeel.components.ui.components.common.scrollbar.config.layersType.ScrollbarsLayersType
import com.ifeel.components.ui.components.common.scrollbar.config.layersType.thicknessType.ScrollbarsThicknessType

/**
 * The scrollbars layer config inside the layers container for [ScrollbarsLayersType.Split].
 *
 * @property thicknessType The scrollbars layer [ScrollbarsThicknessType].
 * @property layerGravity The [ScrollbarsLayerGravity].
 * @property paddingValues The scrollbars layer [PaddingValues].
 * @see ScrollbarsLayersType
 */
data class ScrollbarsLayerConfig(
    val thicknessType: ScrollbarsThicknessType = ScrollbarsLayerConfigDefaults.ThicknessType,
    val layerGravity: ScrollbarsLayerGravity = ScrollbarsLayerConfigDefaults.Gravity,
    val paddingValues: PaddingValues = ScrollbarsLayerConfigDefaults.PaddingValues
)