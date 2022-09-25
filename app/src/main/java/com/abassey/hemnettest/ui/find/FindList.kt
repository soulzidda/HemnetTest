package com.abassey.hemnettest.ui.find

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abassey.hemnettest.models.Advert

@Composable
fun adverts(modifier: Modifier = Modifier, adverts: List<Advert>, selectAdvert: (String) -> Unit) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 10.dp)
            .background(MaterialTheme.colors.background),
    ) {
        adverts.forEach { advert ->
            key(advert.id) {
                FindCard(advert = advert, selectAdvert = selectAdvert)
            }

        }
    }
}