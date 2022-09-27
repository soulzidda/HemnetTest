package com.abassey.hemnettest.ui.find

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abassey.hemnettest.models.Advert
import com.abassey.hemnettest.ui.shared.AdvertViewModel
import com.abassey.hemnettest.ui.shared.AppTopBar
import com.abassey.hemnettest.ui.shared.ScreenLoadingView

@Composable
fun FindScreen(
    viewModel: AdvertViewModel, navController: NavController, selectAdvert: (String) -> Unit = {}
) {
    val adverts = viewModel.adverts.value
    val errorMessage = viewModel.error.value
    val isLoading = viewModel.isLoading
    val headerText = "Sök bostad"

    Scaffold(backgroundColor = Color.White,
        modifier = Modifier.fillMaxHeight(),
        topBar = { AppTopBar(headerText = headerText, navController) }) {
        if (!errorMessage.isNullOrEmpty()) ErrorState(
            errorMessage, Modifier.padding(it)
        ) else Crossfade(
            targetState = isLoading, animationSpec = tween(1000)
        ) { isLoading: Boolean ->
            when (isLoading) {
                false -> adverts(
                    adverts = adverts, selectAdvert = selectAdvert, modifier = Modifier.padding(it)
                )
                true -> ScreenLoadingView()
            }
        }
    }
}

@Composable
fun adverts(
    adverts: List<Advert>,
    selectAdvert: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.background),
    ) {
        var currentPage by remember { mutableStateOf("A") }
        adverts.forEach { advert ->
            key(advert.id) {
                FindCard(advert = advert, selectAdvert = selectAdvert)
            }
        }

    }
}

@Composable
fun ErrorState(errorMessage: String, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(vertical = 10.dp)
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Text(text = errorMessage)
    }
}

