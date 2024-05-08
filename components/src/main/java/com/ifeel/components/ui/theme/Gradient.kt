package com.ifeel.components.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val color_gradient_1_brush = getVerticalGradient(listOf(color_gradient_1_start, color_gradient_1_end))
val color_gradient_2_brush = getVerticalGradient(listOf(color_gradient_2_start, color_gradient_2_end))
val color_gradient_3_brush = getVerticalGradient(listOf(color_gradient_3_start, color_gradient_3_end))
val color_gradient_4_brush = getVerticalGradient(listOf(color_gradient_4_start, color_gradient_4_end))
val color_gradient_5_brush = getVerticalGradient(listOf(color_gradient_5_start, color_gradient_5_end))
val color_gradient_6_brush = getVerticalGradient(listOf(color_gradient_6_start, color_gradient_6_end))

private fun getVerticalGradient(colors: List<Color>): Brush = Brush.verticalGradient(colors)