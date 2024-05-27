package com.ifeel.components.ui.components.generic.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.ifeel.components.ui.theme.color_brand_secondary_200
import com.ifeel.components.ui.theme.color_danger_100
import com.ifeel.components.ui.theme.text.BodyTextStyle

private val cardShape = RoundedCornerShape(10.dp)

@Composable
fun AlertInfoCard(text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = color_brand_secondary_200,
                shape = cardShape
            )
            .clip(shape = cardShape)
            .background(color = color_danger_100)
    ) {
        Image(
            painter = painterResource(id = R.drawable.support_agent_ic),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 12.dp, top = 20.dp)
        )

        Text(
            text = text,
            style = BodyTextStyle.Body14Regular.toTextStyle(),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 20.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlertInfoCardPreview() {
    IfeelComponentsTheme {
        AlertInfoCard(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Tu anterior conversación con tu psicólogo guía se ha trasladado al chat de atención al usuario. Puedes acceder a él en el menú superior de este chat."
        )
    }
}