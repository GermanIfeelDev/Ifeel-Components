package com.ifeel.components.ui.components.common.scrollbar.config.layersType

import androidx.compose.foundation.layout.PaddingValues
import com.ifeel.components.ui.components.common.scrollbar.config.ScrollbarsConfig
import com.ifeel.components.ui.components.common.scrollbar.config.layercontenttype.ScrollbarsLayerContentType
import com.ifeel.components.ui.components.common.scrollbar.config.layersType.layerConfig.ScrollbarsLayerConfig
import com.ifeel.components.ui.components.common.scrollbar.config.layersType.thicknessType.ScrollbarsThicknessType

/**
 * The scrollbars layers type configuration for [ScrollbarsConfig].
 *
 * @see ScrollbarsLayerConfig
 * @see ScrollbarsThicknessType
 * @see ScrollbarsLayerContentType
 */
sealed interface ScrollbarsLayersType {

    /**
     * The scrollbars layers type which wraps a knob layer into a background layer. The layers are centered.
     *
     * @property thicknessType The knob [ScrollbarsThicknessType].
     * @property paddingValues The background [PaddingValues].
     */
    data class Wrap(
        val thicknessType: ScrollbarsThicknessType = ScrollbarsLayersTypeDefaults.Wrap.ThicknessType,
        val paddingValues: PaddingValues = ScrollbarsLayersTypeDefaults.Wrap.PaddingValues
    ) : ScrollbarsLayersType

    /**
     * The scrollbars layers type which splits a knob and a background layer into each own [ScrollbarsLayerConfig].
     *
     * @property backgroundLayerConfig The knob [ScrollbarsLayerConfig].
     * @property knobLayerConfig The background [ScrollbarsLayerConfig].
     */
    data class Split(
        val backgroundLayerConfig: ScrollbarsLayerConfig = ScrollbarsLayersTypeDefaults.Split.BackgroundLayerConfig,
        val knobLayerConfig: ScrollbarsLayerConfig = ScrollbarsLayersTypeDefaults.Split.KnobLayerConfig
    ) : ScrollbarsLayersType
}