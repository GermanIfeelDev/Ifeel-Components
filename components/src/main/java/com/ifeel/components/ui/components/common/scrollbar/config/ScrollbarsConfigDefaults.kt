package com.ifeel.components.ui.components.common.scrollbar.config

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import com.ifeel.components.ui.components.common.scrollbar.ScrollbarsState
import com.ifeel.components.ui.components.common.scrollbar.config.layercontenttype.ScrollbarsLayerContentType
import com.ifeel.components.ui.components.common.scrollbar.config.layersType.ScrollbarsLayersType
import com.ifeel.components.ui.components.common.scrollbar.config.sizetype.ScrollbarsSizeType
import com.ifeel.components.ui.components.common.scrollbar.config.visibilitytype.ScrollbarsVisibilityType

/**
 * The default values for [ScrollbarsConfig].
 *
 * @see ScrollbarsState
 * @see ScrollbarsGravity
 * @see ScrollbarsOrientation
 */
object ScrollbarsConfigDefaults {

    /** The default [ScrollbarsGravity]. */
    val Gravity: ScrollbarsGravity = ScrollbarsGravity.End

    /** The default is reverse layout indicator. */
    const val IsReverseLayout: Boolean = false

    /** The default scrollbars layers container [PaddingValues]. */
    val PaddingValues: PaddingValues = PaddingValues(all = 4.dp)

    /** The default [ScrollbarsSizeType]. */
    val SizeType: ScrollbarsSizeType = ScrollbarsSizeType.Full

    /** The default [ScrollbarsLayersType]. */
    val LayersType: ScrollbarsLayersType = ScrollbarsLayersType.Wrap()

    /** The default background [ScrollbarsLayerContentType]. */
    val BackgroundLayerContentType: ScrollbarsLayerContentType = ScrollbarsLayerContentType.None

    /** The default knob [ScrollbarsLayerContentType]. */
    val KnobLayerContentType: ScrollbarsLayerContentType = ScrollbarsLayerContentType.Default.Colored.IdleActive()

    /** The default [ScrollbarsVisibilityType]. */
    val VisibilityType: ScrollbarsVisibilityType = ScrollbarsVisibilityType.Dynamic.Fade()
}
