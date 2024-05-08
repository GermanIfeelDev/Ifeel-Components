package com.ifeel.components.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.ifeel.components.R

val sofiaProFontFamily = FontFamily(
    Font(R.font.sofia_pro_semibold, FontWeight.SemiBold),
    Font(R.font.sofia_pro_medium, FontWeight.Medium),
    Font(R.font.sofia_pro_regular, FontWeight.Normal),
    Font(R.font.sofia_pro_semibold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.sofia_pro_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.sofia_pro_regular_italic, FontWeight.Normal, FontStyle.Italic),
)

val recoletaFontFamily = FontFamily(
    Font(R.font.recoleta_semibold, FontWeight.SemiBold),
    Font(R.font.recoleta_medium, FontWeight.Medium),
    Font(R.font.recoleta_regular, FontWeight.Normal),
)