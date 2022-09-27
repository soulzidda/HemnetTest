package com.abassey.hemnettest.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abassey.hemnettest.models.Advert
import com.abassey.hemnettest.ui.shared.AdvertViewModel
import com.abassey.hemnettest.ui.shared.AppTopBar
import com.abassey.hemnettest.ui.shared.Image
import com.abassey.hemnettest.ui.shared.SubHeadingText

@Composable
fun DetailsScreen(
    viewModel: AdvertViewModel, advertId: String, navController: NavController
) {
    val advert = viewModel.filterAdverts(advertId)
    val headerText = "Annonsinformation"
    Scaffold(backgroundColor = Color.White,
        topBar = { AppTopBar(headerText = headerText, navController) }) {
        Column(Modifier.padding(it)) {
            DetailsLayout(advert = advert)
        }
    }
}

@Composable
fun DetailsLayout(advert: Advert?) {
    Column(
        Modifier
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 10.dp, vertical = 16.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (advert != null) {
            val isArea = advert.type == "Area"
            Image(
                modifier = Modifier.height(300.dp),
                contentAlignment = Alignment.BottomCenter,
                isHighlighted = false,
                image = advert.image as String
            )
            SubHeadingText(
                advert = advert, isArea = isArea
            )
        }
    }
}

