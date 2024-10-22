package com.ifeel.components.ui.components.common.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ifeel.components.R
import com.ifeel.components.ui.components.common.chip.IfeelSuggestionChip
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_800
import com.ifeel.components.ui.theme.color_text_200
import com.ifeel.components.ui.theme.color_text_cold_500
import com.ifeel.components.ui.theme.text.BodyTextStyle
import com.ifeel.components.ui.theme.text.CaptionTextStyle

/**
 * Displays a card representing a tool with an image, title, type of exercise, time,
 * and a favorite button. The card can be clicked to trigger a callback.
 *
 * For the design details, refer to the [Selfcare Feature Figma Design](https://www.figma.com/design/zN48vKeTN3r7aEMZeeUGvc/01-App-de-usuario-(2023-2024)?node-id=11839-2437&node-type=frame&t=1dYllWdkIo8x2u4V-0).
 *
 * @param title The title of the tool.
 * @param typeOfExercise The type of exercise associated with the tool.
 * @param done Indicates whether the tool has been marked as done.
 * @param imageUrl The URL of the image to display for the tool.
 * @param time The time associated with the exercise.
 * @param onToolClicked Callback to be invoked when the tool card is clicked.
 * @param onFavoriteBtnClicked Callback to be invoked when the favorite button is clicked.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolCard(
    title: String,
    typeOfExercise: String,
    done: Boolean,
    imageUrl: String,
    time: String,
    onToolClicked: () -> Unit,
    onFavoriteBtnClicked: () -> Unit,
) {
    Card(
        onClick = onToolClicked,
        modifier = Modifier.size(height = 208.dp, width = 200.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, color_text_200),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentScale = ContentScale.Crop
        )

        Column {
            Text(
                text = title,
                style = BodyTextStyle.Body16Regular.toTextStyle(),
                color = color_brand_primary_800,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 12.dp)
            )

            Divider(
                color = color_text_200,
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IfeelSuggestionChip(
                    text = typeOfExercise,
                    modifier = Modifier.padding(start = 12.dp, top = 4.dp, bottom = 4.dp)
                )

                Text(
                    text = time,
                    style = CaptionTextStyle.Caption12Regular.toTextStyle(),
                    color = color_text_cold_500,
                    modifier = Modifier.padding(start = 12.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = onFavoriteBtnClicked,
                    modifier = Modifier
                ) {
                    Icon(
                        painter = painterResource(id = if (done) R.drawable.favorite_tool_selected_ic else R.drawable.favorite_tool_unselected_ic),
                        contentDescription = null,
                        tint = Color.Unspecified,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
internal fun ToolCardPreview() {
    var exerciseDone by rememberSaveable { mutableStateOf(false) }

    IfeelComponentsTheme {
        Column {
            ToolCard(
                title = "¿Sabes lo que quieres en tu vida? Aclara tus objetivos",
                typeOfExercise = "Meditacion",
                done = exerciseDone,
                imageUrl = "https://media.istockphoto.com/id/691524194/photo/family-having-fun-at-home.jpg?s=612x612&w=0&k=20&c=jn3iQ4oKsfl4RgzxGuSF_iX9LehtyfdS9aD5gcq-TXU=",
                time = "5 min",
                onToolClicked = { },
                onFavoriteBtnClicked = { exerciseDone = !exerciseDone }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ToolCard(
                title = "Meditacion para la ansiedad",
                typeOfExercise = "Post",
                done = exerciseDone,
                imageUrl = "https://media.istockphoto.com/id/691524194/photo/family-having-fun-at-home.jpg?s=612x612&w=0&k=20&c=jn3iQ4oKsfl4RgzxGuSF_iX9LehtyfdS9aD5gcq-TXU=",
                time = "5 min",
                onToolClicked = { },
                onFavoriteBtnClicked = { exerciseDone = !exerciseDone })

            Spacer(modifier = Modifier.height(16.dp))

            ToolCard(
                title = "Chocolate",
                typeOfExercise = "Podcast",
                done = exerciseDone,
                imageUrl = "https://media.istockphoto.com/id/691524194/photo/family-having-fun-at-home.jpg?s=612x612&w=0&k=20&c=jn3iQ4oKsfl4RgzxGuSF_iX9LehtyfdS9aD5gcq-TXU=",
                time = "5 min",
                onToolClicked = { },
                onFavoriteBtnClicked = { exerciseDone = !exerciseDone })
        }
    }

}