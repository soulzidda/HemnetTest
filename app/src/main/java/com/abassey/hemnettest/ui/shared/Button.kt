package com.abassey.hemnettest.ui.shared

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abassey.hemnettest.ui.theme.HemnetGreen

@Composable
fun CtaButton(label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(all = Dp(10F)),
        enabled = true,
        border = BorderStroke(width = 1.dp, brush = SolidColor(HemnetGreen)),
        colors = ButtonDefaults.buttonColors(backgroundColor = HemnetGreen),
        shape = MaterialTheme.shapes.medium,
    ) {
        Text(text = label, color = Color.White)
    }
}