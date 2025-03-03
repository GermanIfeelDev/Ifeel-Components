package com.ifeel.components.ui.components.common.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_text_400

@Composable
fun LocaleButton(
    imageUrl: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedIconButton(
        onClick = onClick,
        border = BorderStroke(0.dp, Color.Transparent),
        modifier = modifier
            .border(
                width = 1.dp,
                color = color_text_400,
                shape = RoundedCornerShape(6.dp)
            )
            .clip(shape = RoundedCornerShape(6.dp))
            .background(color = Color.White)
            .size(height = 44.dp, width = 48.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Preview
@Composable
fun LocaleButtonPreview() {
    IfeelComponentsTheme {
        LocaleButton(onClick = {}, imageUrl = "https://ifeel-media.s3.eu-west-2.amazonaws.com/images/flags/img_de.png")
    }
}