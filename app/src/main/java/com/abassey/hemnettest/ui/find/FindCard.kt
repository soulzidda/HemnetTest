package com.abassey.hemnettest.ui.find

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.abassey.hemnettest.R
import com.abassey.hemnettest.models.Advert
import com.abassey.hemnettest.ui.theme.HemnetTestTheme


@Composable
fun FindCard(
    modifier: Modifier = Modifier,
    advert: Advert,
    selectAdvert: (String) -> Unit = {},
) {
    val border = if (advert.type == "HighlightedProperty") BorderStroke(
        width = 4.dp, color = Color.Magenta
    ) else null


    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .clickable(onClick = { selectAdvert(advert.id) }), border = border
    ) {
        Column(
            Modifier.background(MaterialTheme.colors.background)
        ) {
            Image(
                painter = rememberImagePainter(advert.image, builder = {
                    placeholder(R.drawable.placeholder)

                }),
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.3f),
            )
            TextRowOne(
                isProperty = advert.type == "Area",
                area = advert.area,
                rooms = advert.numberOfRooms,
                streetAddress = advert.streetAddress
            )

            TextRowTwo(
                isProperty = advert.type == "Area",
                area = advert.area,
                municipality = advert.municipality,
                rating = advert.rating
            )
            TextRowThree(
                isProperty = advert.type == "Area",
                daysOnHemnet = advert.daysOnHemnet,
                askingPrice = advert.askingPrice,
                livingArea = advert.livingArea,
                averagePrice = advert.averagePrice,
                rooms = advert.numberOfRooms
            )

        }
    }
}


@Composable
private fun TextRowOne(isProperty: Boolean, area: String, rooms: Int?, streetAddress: String?) {
    if (isProperty) Text(
        modifier = Modifier.padding(
            horizontal = 10.dp, vertical = 0.dp
        ), text = area
    ) else Text(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 0.dp),
        text = "${streetAddress}, ${rooms}tr",
    )
}

@Composable
private fun TextRowTwo(isProperty: Boolean, area: String?, municipality: String?, rating: String?) {
    if (isProperty) Text(
        modifier = Modifier.padding(
            horizontal = 10.dp, vertical = 0.dp
        ), text = "Betyg: $rating"
    ) else Text(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 0.dp),
        text = "$area, $municipality",
    )
}

@Composable
private fun TextRowThree(
    isProperty: Boolean,
    daysOnHemnet: Int?,
    askingPrice: String?,
    livingArea: Short?,
    averagePrice: String?,
    rooms: Int?
) {
    if (isProperty) Text(
        modifier = Modifier.padding(
            horizontal = 10.dp, vertical = 0.dp
        ),
        text = "Snittpris: $averagePrice",
    ) else Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$askingPrice $livingArea $rooms rum",
        )
        Text(text = "$daysOnHemnet dagar")
    }
}


@Composable
@Preview(name = "HomePoster Dark Theme")
private fun FindCardPreview() {
    HemnetTestTheme(darkTheme = false) {
        FindCard(advert = Advert.mock())
    }
}