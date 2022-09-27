package com.abassey.hemnettest.ui.shared

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.abassey.hemnettest.models.Advert

@Composable
fun FadedText(text: String, modifier: Modifier, fontSize: TextUnit) {
    Text(
        text = text, modifier.alpha(0.6f), fontSize = fontSize
    )
}

@Composable
fun MediumText(text: String) {
    Text(
        modifier = Modifier, text = text, fontWeight = FontWeight.Medium
    )
}

@Composable
fun SuperscriptText(text: String, appendText: String) {
    Text(fontSize = 14.sp, text = buildAnnotatedString {
        append(text)
        withStyle(superscript) {
            append(appendText)
        }
    })
}

@Composable
fun SubHeadingText(advert: Advert, isArea: Boolean) {
    Text(
        modifier = Modifier,
        text = if (isArea) "${advert.area}" else "${advert.streetAddress}, ${advert.numberOfRooms}tr",
        fontWeight = FontWeight.Bold
    )
}

private val superscript = SpanStyle(
    baselineShift = BaselineShift.Superscript, fontSize = 8.sp, color = Color.Black
)