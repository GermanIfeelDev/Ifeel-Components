package com.ifeel.components.ui.components.common.scrollbar.config

import androidx.compose.foundation.layout.PaddingValues
import com.ifeel.components.ui.components.common.scrollbar.ScrollbarsState
import com.ifeel.components.ui.components.common.scrollbar.config.layercontenttype.ScrollbarsLayerContentType
import com.ifeel.components.ui.components.common.scrollbar.config.layersType.ScrollbarsLayersType
import com.ifeel.components.ui.components.common.scrollbar.config.sizetype.ScrollbarsSizeType
import com.ifeel.components.ui.components.common.scrollbar.config.visibilitytype.ScrollbarsVisibilityType
import com.ifeel.components.ui.components.common.scrollbar.scrolltype.ScrollbarsScrollType

/**
 * The scrollbars appearance configuration for [ScrollbarsState].
 *
 * The [orientation] should be the same as the orientation of [ScrollbarsScrollType.knobType] state.
 *
 * @property orientation The [ScrollbarsOrientation].
 * @property gravity The [ScrollbarsGravity].
 * @property isReverseLayout The reverse layout indicator.
 * @property paddingValues The scrollbars layers container [PaddingValues].
 * @property sizeType The [ScrollbarsSizeType].
 * @property layersType The [ScrollbarsLayersType].
 * @property backgroundLayerContentType The background [ScrollbarsLayerContentType].
 * @property knobLayerContentType The knob [ScrollbarsLayerContentType].
 * @property visibilityType The [ScrollbarsVisibilityType].
 * @see ScrollbarsScrollType
 */
data class ScrollbarsConfig(
    val orientation: ScrollbarsOrientation,
    val gravity: ScrollbarsGravity = ScrollbarsConfigDefaults.Gravity,
    val isReverseLayout: Boolean = ScrollbarsConfigDefaults.IsReverseLayout,
    val paddingValues: PaddingValues = ScrollbarsConfigDefaults.PaddingValues,
    val sizeType: ScrollbarsSizeType = ScrollbarsConfigDefaults.SizeType,
    val layersType: ScrollbarsLayersType = ScrollbarsConfigDefaults.LayersType,
    val backgroundLayerContentType: ScrollbarsLayerContentType = ScrollbarsConfigDefaults.BackgroundLayerContentType,
    val knobLayerContentType: ScrollbarsLayerContentType = ScrollbarsConfigDefaults.KnobLayerContentType,
    val visibilityType: ScrollbarsVisibilityType = ScrollbarsConfigDefaults.VisibilityType
)