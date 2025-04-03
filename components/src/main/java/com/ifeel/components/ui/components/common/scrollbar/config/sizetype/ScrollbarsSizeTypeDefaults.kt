package com.ifeel.components.ui.components.common.scrollbar.config.sizetype

import androidx.compose.ui.unit.dp

import com.ifeel.components.ui.components.common.scrollbar.config.ScrollbarsConfig

/**
 * The default values for [ScrollbarsSizeType].
 *
 * @see ScrollbarsConfig
 */
object ScrollbarsSizeTypeDefaults {

    /** The default values for [ScrollbarsSizeType.Fraction]. */
    object Fraction {

        /** The default [ScrollbarsSizeType.Fraction.fraction]. */
        const val Fraction = 0.5F
    }

    /** The default values for [ScrollbarsSizeType.Exact]. */
    object Exact {

        /** The default [ScrollbarsSizeType.Exact.size]. */
        val Size = 300.dp
    }
}
