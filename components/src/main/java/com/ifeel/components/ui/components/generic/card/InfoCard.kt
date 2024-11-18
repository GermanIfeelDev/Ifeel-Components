package com.ifeel.components.ui.components.generic.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_200
import com.ifeel.components.ui.theme.color_brand_primary_light_200
import com.ifeel.components.ui.theme.text.BodyTextStyle

private val cardShape = RoundedCornerShape(10.dp)

@Composable
fun InfoCard(text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = color_brand_primary_200,
                shape = cardShape
            )
            .clip(shape = cardShape)
            .background(color = color_brand_primary_light_200)
    ) {
        Image(
            painter = painterResource(id = R.drawable.alert_info_card_ic),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 12.dp, top = 20.dp)
        )

        Text(
            text = text,
            style = BodyTextStyle.Body16Regular.toTextStyle(),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 20.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InfoCardPreview() {
    IfeelComponentsTheme {
        InfoCard(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Tu anterior conversación con tu psicólogo guía se ha trasladado al chat de atención al usuario. Puedes acceder a él en el menú superior de este chat."
        )
    }
}