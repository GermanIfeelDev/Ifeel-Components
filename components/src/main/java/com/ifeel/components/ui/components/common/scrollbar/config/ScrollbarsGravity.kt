package com.ifeel.components.ui.components.common.scrollbar.config

import com.ifeel.components.ui.components.common.scrollbar.config.visibilitytype.ScrollbarsVisibilityType

/**
 * The scrollbars layers container gravity for [ScrollbarsConfig].
 *
 * @see ScrollbarsOrientation
 * @see ScrollbarsVisibilityType
 */
enum class ScrollbarsGravity {

    /** The scrollbars layers container gravity at the start anchor (left or top, depends on [ScrollbarsOrientation]). */
    Start,

    /** The scrollbars layers container gravity at the end anchor (right or bottom, depends on [ScrollbarsOrientation]). */
    End
}