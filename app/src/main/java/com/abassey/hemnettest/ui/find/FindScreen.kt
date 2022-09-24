package com.abassey.hemnettest.ui.find

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abassey.hemnettest.models.Advert
import com.abassey.hemnettest.ui.shared.AppTopBar


@Composable
fun FindScreen(navController: NavController, selectAdvert: (String) -> Unit = {}) {
    val headerText = "Sök bostad"
    Scaffold(
        backgroundColor = Color.White,
        topBar = { AppTopBar(headerText = headerText, navController) }) {
        adverts(adverts = Advert.advertList, selectAdvert = selectAdvert)
    }

}

@Composable
fun adverts(modifier: Modifier = Modifier, adverts: List<Advert>, selectAdvert: (String) -> Unit) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 0.dp, vertical = 10.dp)
            .background(MaterialTheme.colors.background),
    ) {
        Advert.advertList.forEach { advert ->
            key(advert.id) {
                FindCard(advert = advert, selectAdvert = selectAdvert)
            }

        }
    }
}