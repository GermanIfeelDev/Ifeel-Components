package com.ifeel.components.ui.components.common.dialog

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ifeel.components.ui.components.generic.button.PrimaryButton
import com.ifeel.components.ui.theme.text.BodyTextStyle
import com.ifeel.components.ui.theme.text.TitleTextStyle

@Composable
fun ErrorDialog(
    title: String,
    description: String,
    acceptBtnText: String,
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White) ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = title,
                    style = TitleTextStyle.TitleSemiBold.toTextStyle().copy(textAlign = TextAlign.Center),
                    modifier = Modifier.padding(top = 28.dp, start = 32.dp, end = 32.dp),
                )
                Text(
                    text = description,
                    style = BodyTextStyle.Body16Regular.toTextStyle().copy(color = Color.Black, textAlign = TextAlign.Center),
                    modifier = Modifier.padding(top = 12.dp, start = 32.dp, end = 32.dp)
                )
                PrimaryButton(
                    text = acceptBtnText,
                    onClick = onDismissRequest,
                    modifier = Modifier.padding(vertical = 32.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ErrorDialogPreview() {
    var showDialog by rememberSaveable {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.padding(40.dp)) {
        TextButton(onClick = { showDialog = !showDialog }) {
            Text(text = "Show dialog")
        }
    }

    if (showDialog) {
        ErrorDialog(
            "Oops!",
            "Server error occurred. Please try again later.",
            "Accept",
            onDismissRequest = { showDialog = false })

    }

}