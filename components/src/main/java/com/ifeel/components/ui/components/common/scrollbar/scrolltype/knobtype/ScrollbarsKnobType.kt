package com.ifeel.components.ui.components.common.scrollbar.scrolltype.knobtype

import androidx.compose.animation.core.AnimationSpec
import com.ifeel.components.ui.components.common.scrollbar.scrolltype.ScrollbarsScrollType

/**
 * The scrollbars generic knob configuration for [ScrollbarsScrollType].
 *
 * @see ScrollbarsStaticKnobType
 * @see ScrollbarsDynamicKnobType
 */
interface ScrollbarsKnobType {

    /** The knob [AnimationSpec]. Null disables the animation. */
    val animationSpec: AnimationSpec<Float>?
}