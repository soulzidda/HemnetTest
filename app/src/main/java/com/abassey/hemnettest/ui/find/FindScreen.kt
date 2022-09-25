package com.abassey.hemnettest.ui.find

import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.abassey.hemnettest.ui.shared.AppTopBar
import com.abassey.hemnettest.ui.theme.HemnetGreen
import com.abassey.hemnettest.utils.loadDataFromJson

@Composable
fun FindScreen(
    navController: NavController, selectAdvert: (String) -> Unit = {}
) {
    val context = LocalContext.current
    val adverts = loadDataFromJson(context)

    val headerText = "Sök bostad"
    Scaffold(backgroundColor = Color.White,
        topBar = { AppTopBar(headerText = headerText, navController) }) {
        if (adverts != null) {
            adverts(adverts = adverts, selectAdvert = selectAdvert, modifier = Modifier.padding(it))
        } else {
            CircularProgressIndicator(
                color = HemnetGreen,
            )
        }
    }
}

