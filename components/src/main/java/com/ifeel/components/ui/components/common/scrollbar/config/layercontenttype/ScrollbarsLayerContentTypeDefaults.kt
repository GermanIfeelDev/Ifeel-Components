package com.ifeel.components.ui.components.common.scrollbar.config.layercontenttype

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import com.ifeel.components.ui.components.common.scrollbar.config.ScrollbarsConfig
import com.ifeel.components.ui.components.common.scrollbar.config.layercontenttype.layercontentstyletype.ScrollbarsLayerContentStyleType

/**
 * The default values for [ScrollbarsLayerContentType].
 *
 * @see ScrollbarsConfig
 */
object ScrollbarsLayerContentTypeDefaults {

    /** The default values for [ScrollbarsLayerContentType.Default]. */
    object Default {

        /** The default content shape. */
        val Shape: Shape = CircleShape

        /**
         * The default content brush.
         *
         * @see Colored.IdleColor
         */
        val Brush: Brush = SolidColor(value = Colored.IdleColor)

        /** The default [ScrollbarsLayerContentStyleType]. */
        val StyleType: ScrollbarsLayerContentStyleType = ScrollbarsLayerContentStyleType.Background

        /** The default values for [ScrollbarsLayerContentType.Default.Colored]. */
        object Colored {

            /** The default content idle color. */
            val IdleColor: Color = Color.LightGray.copy(alpha = 0.65F)

            /** The default values for [ScrollbarsLayerContentType.Default.Colored.IdleActive]. */
            object IdleActive {

                /** The default content active color. */
                val ActiveColor: Color = Color.LightGray

                /** The default content active color in [AnimationSpec]. */
                val InAnimationSpec: AnimationSpec<Color>
                    get() = spring()

                /** The default content active color out [AnimationSpec]. */
                val OutAnimationSpec: AnimationSpec<Color>
                    get() = tween(delayMillis = 750)
            }
        }
    }
}