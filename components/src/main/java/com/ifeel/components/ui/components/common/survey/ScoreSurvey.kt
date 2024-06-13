package com.ifeel.components.ui.components.common.survey

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ifeel.components.R
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_200
import com.ifeel.components.ui.theme.color_brand_primary_800
import com.ifeel.components.ui.theme.color_text_cold_500
import com.ifeel.components.ui.theme.text.BodyTextStyle
import com.ifeel.components.ui.theme.text.CaptionTextStyle

/**
 * Displays a survey for scoring items with descriptions for the first and last rating items.
 *
 * [Design](https://www.figma.com/design/7GJjL34sYDK9gXPX5RRjmB/Maccabi?node-id=798-13199&t=y1FUdrSyqexAwBMO-4)
 *
 * @param ratingItems The list of rating items, each represented by a Pair of text and a boolean indicating if it's selected.
 * @param firstRatingDescription The description string for the first rating item.
 * @param lastRatingDescription The description string for the last rating item.
 * @param onRatingClicked Lambda function invoked when a rating item is clicked.
 * @param modifier Modifier for this layout. Defaults to Modifier.
 */
@Composable
fun ScoreSurvey(
    ratingItems: List<Pair<String, Boolean>>,
    firstRatingDescription: String,
    lastRatingDescription: String,
    onRatingClicked: (Pair<String, Boolean>) -> Unit,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (ratingList) = createRefs()

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(ratingList) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            itemsIndexed(ratingItems) { index, item ->
                when (index) {
                    0 -> {
                        ScoreSurveyItem(
                            ratingItem = item,
                            onRatingClicked = onRatingClicked,
                            ratingDescriptionString = firstRatingDescription,
                            modifier = Modifier
                        )
                    }
                    ratingItems.size - 1 -> {
                        ScoreSurveyItem(
                            ratingItem = item,
                            onRatingClicked = onRatingClicked,
                            ratingDescriptionString = lastRatingDescription
                        )
                    }
                    else -> {
                        ScoreSurveyItem(
                            ratingItem = item,
                            onRatingClicked = onRatingClicked
                        )
                    }
                }
            }
        }
    }
}


@Composable
private fun ScoreSurveyItem(
    ratingItem: Pair<String, Boolean>,
    onRatingClicked: (Pair<String, Boolean>) -> Unit,
    modifier: Modifier = Modifier,
    ratingDescriptionString: String? = null,
) {
    ConstraintLayout(modifier = modifier) {
        val (ratingIcon, ratingText, ratingDescription) = createRefs()

        IconButton(
            onClick = { onRatingClicked(ratingItem.copy(second = !ratingItem.second)) },
            modifier = Modifier
                .padding(end = 14.dp)
                .size(40.dp)
                .wrapContentSize()
                .constrainAs(ratingIcon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }

        ) {
            Icon(
                painter = painterResource(id = if (ratingItem.second) R.drawable.rating_survey_selected_ic else R.drawable.rating_survey_unselected_ic),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }

        ratingDescriptionString?.let {
            ScoreSurveyItemDescription(
                ratingDescriptionString,
                modifier = Modifier.constrainAs(ratingDescription) {
                    top.linkTo(ratingIcon.top)
                    bottom.linkTo(ratingIcon.bottom)
                    end.linkTo(ratingIcon.start, margin = 12.dp)
                }
            )
        }

        Text(
            text = ratingItem.first,
            style = BodyTextStyle.Body16Regular.toTextStyle().copy(color = color_text_cold_500),
            modifier = Modifier.constrainAs(ratingText) {
                top.linkTo(ratingIcon.top)
                bottom.linkTo(ratingIcon.bottom)
                start.linkTo(ratingIcon.end)
            }
        )
    }
}

@Composable
private fun ScoreSurveyItemDescription(description: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(color_brand_primary_200)
    ) {
        Text(
            text = description,
            style = CaptionTextStyle.Caption12Regular.toTextStyle()
                .copy(color = color_brand_primary_800),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFE37C67)
@Composable
private fun ScoreSurveyPreview() {
    val ratingItems = remember {
        mutableStateListOf(
            Pair("0 not at all", false),
            Pair("2", false),
            Pair("3 a little", false),
            Pair("4", false),
            Pair("5 heavily", false)
        )
    }

    IfeelComponentsTheme {
        ScoreSurvey(
            ratingItems = ratingItems,
            firstRatingDescription = "Low",
            lastRatingDescription = "High",
            onRatingClicked = { ratingClicked ->
                val index = ratingItems.indexOfFirst { it.first == ratingClicked.first }

                if (index != -1) {

                    for (i in ratingItems.indices) { //TODO CAMBIAR POR         ratingItems.replaceAll { it.copy(selected = false) } cuando subamos la min api a 24
                        ratingItems[i] = ratingItems[i].copy(second = false)
                    }

                    ratingItems[index] = ratingClicked
                }
            }
        )
    }
}