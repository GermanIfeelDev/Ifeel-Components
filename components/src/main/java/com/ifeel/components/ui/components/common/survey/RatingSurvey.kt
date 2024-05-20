package com.ifeel.components.ui.components.common.survey

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.ifeel.components.ui.components.common.survey.vo.RatingSurveyItemVO
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_brand_primary_200
import com.ifeel.components.ui.theme.color_brand_primary_800
import com.ifeel.components.ui.theme.color_text_cold_500
import com.ifeel.components.ui.theme.text.BodyTextStyle
import com.ifeel.components.ui.theme.text.CaptionTextStyle

@Composable
fun RatingSurvey(
    ratingItems: List<RatingSurveyItemVO>,
    firstRatingDescription: String,
    lastRatingDescription: String,
    onRatingClicked: (RatingSurveyItemVO) -> Unit,
    modifier: Modifier = Modifier
) {

    ConstraintLayout(modifier = modifier) {
        val (initialDescriptionRating, lastDescriptionRating, ratingList) = createRefs()

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.constrainAs(ratingList) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            items(ratingItems) { item ->
                RatingSurveyItem(
                    ratingItem = item,
                    onRatingClicked = onRatingClicked
                )
            }
        }

        RatingItemDescription(
            firstRatingDescription,
            modifier = Modifier.constrainAs(initialDescriptionRating) {
                top.linkTo(parent.top, margin = 4.dp)
                end.linkTo(ratingList.start, margin = 14.dp)
            }
        )
        RatingItemDescription(
            lastRatingDescription,
            modifier = Modifier.constrainAs(lastDescriptionRating) {
                bottom.linkTo(parent.bottom, margin = 4.dp)
                end.linkTo(ratingList.start, margin = 14.dp)
            })
    }
}


@Composable
private fun RatingSurveyItem(
    ratingItem: RatingSurveyItemVO,
    onRatingClicked: (RatingSurveyItemVO) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        IconButton(
            onClick = { onRatingClicked(ratingItem) },
            modifier = Modifier.padding(end = 14.dp).size(40.dp)
        ) {
            Icon(
                painter = painterResource(id = if (ratingItem.selected) R.drawable.rating_survey_selected_ic else R.drawable.rating_survey_unselected_ic),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }

        Text(
            text = ratingItem.rating.toString(),
            style = BodyTextStyle.Body16Regular.toTextStyle().copy(color = color_text_cold_500)
        )
    }
}

@Composable
private fun RatingItemDescription(description: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(color_brand_primary_200)
    ) {
        Text(
            text = description,
            style = CaptionTextStyle.Caption12Regular.toTextStyle().copy(color = color_brand_primary_800),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFE37C67)
@Composable
private fun RatingSurveyPreview() {
    var ratingItems = remember {
        mutableStateListOf(
            RatingSurveyItemVO(1),
            RatingSurveyItemVO(2),
            RatingSurveyItemVO(3),
            RatingSurveyItemVO(4),
            RatingSurveyItemVO(5)
        )
    }

    IfeelComponentsTheme {
        RatingSurvey(
            ratingItems = ratingItems,
            firstRatingDescription = "Low",
            lastRatingDescription = "High",
            onRatingClicked = {ratingClicked ->
                val index = ratingItems.indexOf(ratingClicked)

                if (index != -1) {

                    for (i in ratingItems.indices) { //TODO CAMBIAR POR         ratingItems.replaceAll { it.copy(selected = false) } cuando subamos la min api a 24
                        ratingItems[i] = ratingItems[i].copy(selected = false)
                    }

                    ratingItems[index] = ratingClicked.copy(selected = ratingClicked.selected.not())
                }
            }
        )
    }
}