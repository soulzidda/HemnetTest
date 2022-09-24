package com.abassey.hemnettest.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.abassey.hemnettest.ui.shared.AppTopBar


@Composable
fun AdvertDetailsScreen(advertId: String, navController: NavController) {
    val headerText = "Annonsinformation"
    Scaffold(
        backgroundColor = Color.White,
        topBar = { AppTopBar(headerText = headerText, navController) }) {
        Column() {
            Text(text = "Id of selected advert is $advertId")
        }
    }


}

