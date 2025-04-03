package com.ifeel.components.ui.components.common.scrollbar.config.visibilitytype

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import com.ifeel.components.ui.components.common.scrollbar.config.ScrollbarsConfig

/**
 * The default values for [ScrollbarsVisibilityType].
 *
 * @see ScrollbarsConfig
 */
object ScrollbarsVisibilityTypeDefaults {

    /** The default values for [ScrollbarsVisibilityType.Dynamic]. */
    object Dynamic {

        /** The default in [AnimationSpec]. */
        val InAnimationSpec: AnimationSpec<Float>
            get() = spring()

        /** The default out [AnimationSpec]. */
        val OutAnimationSpec: AnimationSpec<Float>
            get() = tween(delayMillis = 750)

        /** The default is faded indicator. */
        const val IsFaded: Boolean = true

        /** The default is visible when scroll is not possible (short content) indicator. */
        const val IsVisibleWhenScrollNotPossible: Boolean = false

        /** The default is visible on any touch/press down indicator. */
        const val IsVisibleOnTouchDown: Boolean = false

        /** The default are scrollbars statically visible only when the scroll is possible indicator. */
        const val IsStaticWhenScrollPossible: Boolean = true

        /** The default values for [ScrollbarsVisibilityType.Dynamic.Scale]. */
        object Scale {

            /** The default start scale. The stop scale is at 1.0F. */
            const val StartScale = 0.75F
        }
    }
}