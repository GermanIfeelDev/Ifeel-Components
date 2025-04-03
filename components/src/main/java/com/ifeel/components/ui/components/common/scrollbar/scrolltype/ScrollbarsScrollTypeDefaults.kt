package com.ifeel.components.ui.components.common.scrollbar.scrolltype

import com.ifeel.components.ui.components.common.scrollbar.ScrollbarsState
import com.ifeel.components.ui.components.common.scrollbar.scrolltype.knobtype.ScrollbarsDynamicKnobType
import com.ifeel.components.ui.components.common.scrollbar.scrolltype.knobtype.ScrollbarsStaticKnobType

/**
 * The default values for [ScrollbarsScrollType].
 *
 * @see ScrollbarsState
 */
object ScrollbarsScrollTypeDefaults {

    /** The default static [ScrollbarsStaticKnobType]. */
    val StaticKnobType: ScrollbarsStaticKnobType = ScrollbarsStaticKnobType.Auto()

    /** The default dynamic [ScrollbarsStaticKnobType]. */
    val DynamicKnobType: ScrollbarsDynamicKnobType = ScrollbarsDynamicKnobType.Auto()
}
