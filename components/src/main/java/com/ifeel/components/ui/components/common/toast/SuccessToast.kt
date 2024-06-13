package com.ifeel.components.ui.components.common.toast

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_success_200
import com.ifeel.components.ui.theme.text.BodyTextStyle

/**
 * Displays a success toast message with an icon and text.
 *
 * [Design](https://www.figma.com/design/7GJjL34sYDK9gXPX5RRjmB/Maccabi?node-id=1182-29259&t=uX8Ux4vrVFXEpSC5-4)
 *
 * @param text The text content of the success toast.
 * @param modifier Modifier for this layout. Defaults to Modifier.
 */
@Composable
fun SuccessToast(text: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(shape = RoundedCornerShape(6.dp))
            .background(color = color_success_200)
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.success_toast_ic),
            contentDescription = null
        )

        Text(
            text = text,
            style = BodyTextStyle.Body16Regular.toTextStyle(),
            modifier = Modifier
                .padding(start = 12.dp)
        )
    }
}

@Preview
@Composable
fun SuccessToastPreview() {
    IfeelComponentsTheme {
        SuccessToast(text = "Se ha enviado correctamente")
    }
}