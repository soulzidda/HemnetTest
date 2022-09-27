package com.abassey.hemnettest.ui.find

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.abassey.hemnettest.ui.shared.AppTopBar

@Composable
fun FindScreen(
    viewModel: FindScreenViewModel,
    navController: NavController, selectAdvert: (String) -> Unit = {}
) {
    val adverts = viewModel.adverts.value


    val headerText = "Sök bostad"
    Scaffold(backgroundColor = Color.White,
        topBar = { AppTopBar(headerText = headerText, navController) }) {
        adverts(adverts = adverts, selectAdvert = selectAdvert, modifier = Modifier.padding(it))
    }
}

