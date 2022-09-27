package com.abassey.hemnettest.ui.shared

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.abassey.hemnettest.ui.theme.HemnetGreen
import com.abassey.hemnettest.ui.theme.HighlightGold

@Composable
fun Image(modifier: Modifier, contentAlignment: Alignment, isHighlighted: Boolean, image: String) {
    Box(
        modifier = modifier
            .border(
                if (isHighlighted) BorderStroke(
                    width = 2.dp, color = HighlightGold
                ) else BorderStroke(
                    width = 0.dp, color = Color.Transparent
                )
            )
            .height(200.dp), contentAlignment = Alignment.BottomCenter
    ) {
        SubcomposeAsyncImage(
            model = image, contentDescription = "test", loading = {
                LinearProgressIndicator(color = HemnetGreen)
            }, modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop
        )
    }
}