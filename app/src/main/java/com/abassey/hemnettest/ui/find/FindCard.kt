package com.abassey.hemnettest.ui.find

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abassey.hemnettest.models.Advert
import com.abassey.hemnettest.ui.shared.*
import com.abassey.hemnettest.ui.theme.HemnetGreen
import com.abassey.hemnettest.ui.theme.HemnetTestTheme
import com.abassey.hemnettest.ui.theme.HighlightGold

@Composable
fun FindCard(
    advert: Advert,
    selectAdvert: (String) -> Unit = {},
) {
    val isHighlighted = advert.type == "HighlightedProperty"
    val isArea = advert.type == "Area"

    Column(
        Modifier
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 10.dp, vertical = 16.dp)
            .clickable(onClick = { selectAdvert(advert.id as String) })
    ) {
        if (isArea) {
            Text(text = "område", fontWeight = FontWeight.Bold, fontSize = 30.sp)
        }
        Image(
            Modifier
                .border(
                    if (isHighlighted) BorderStroke(
                        width = 2.dp, color = HighlightGold
                    ) else BorderStroke(
                        width = 0.dp, color = Color.Transparent
                    )
                )
                .height(200.dp),
            contentAlignment = Alignment.BottomCenter,
            isHighlighted,
            image = advert.image as String
        )
        SubHeadingText(advert = advert, isArea = isArea)
        RatingOrAreaText(advert = advert, isArea = isArea)
        AverageOrFullPrice(advert = advert, isArea = isArea)
    }
}

@Composable
private fun RatingOrAreaText(advert: Advert, isArea: Boolean) {
    if (isArea) {
        MediumText(text = "Betyg: ${advert.rating}")
    } else {
        Row() {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Icon",
                tint = HemnetGreen,
                modifier = Modifier.size(20.dp)
            )
            FadedText(
                text = "${advert.area}, ${advert.municipality}",
                Modifier.padding(horizontal = 5.dp),
                16.sp
            )
        }
    }
}


@Composable
private fun AverageOrFullPrice(advert: Advert, isArea: Boolean) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    if (isArea) {
        MediumText(text = "Snittpris: ${advert.averagePrice}")
    } else {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.width(screenWidth / 2)
            ) {
                Text(
                    text = "${advert.askingPrice}", fontSize = 14.sp
                )
                SuperscriptText(text = "${advert.livingArea} m", appendText = "2")
                Text(
                    text = "${advert.numberOfRooms} rum", fontSize = 14.sp
                )
            }
            FadedText(text = "${advert.daysOnHemnet} dagar", Modifier, fontSize = 14.sp)
        }
    }
}

@Composable
@Preview(name = "HomePoster Dark Theme")
private fun FindCardPreview() {
    HemnetTestTheme(darkTheme = false) {
        FindCard(advert = Advert.mock())
    }
}