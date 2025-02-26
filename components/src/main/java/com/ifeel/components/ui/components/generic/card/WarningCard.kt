package com.ifeel.components.ui.components.generic.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_secondary_200
import com.ifeel.components.ui.theme.color_danger_100
import com.ifeel.components.ui.theme.color_text_700
import com.ifeel.components.ui.theme.text.BodyTextStyle

private val cardShape = RoundedCornerShape(10.dp)

@Composable
fun WarningCard(text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = color_brand_secondary_200,
                shape = cardShape
            )
            .clip(shape = cardShape)
            .background(color = color_danger_100)
            .padding(12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.warning_card_ic),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 8.dp),
        )

        Text(
            text = text,
            style = BodyTextStyle.Body14Regular.toTextStyle(),
            color = color_text_700
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WarningCardPreview() {
    IfeelComponentsTheme {
        WarningCard(
            modifier = Modifier.padding(20.dp),
            text = "Contraseña o email incorrectos. Por motivos de seguridad, después de 10 intentos fallidos tu acceso se bloqueará durante 60 minutos."
        )
    }
}