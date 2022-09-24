package com.abassey.hemnettest.ui.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abassey.hemnettest.ui.theme.HemnetGreen

@Composable
fun AppTopBar(headerText: String, navController: NavController) {
    val backButtonActive: Boolean = navController.previousBackStackEntry != null


    TopAppBar(
        backgroundColor = HemnetGreen,
    ) {
        Row() {
            if (backButtonActive) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,

                    tint = Color.White,
                    contentDescription = "Back button",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
            }
            Text(
                modifier = Modifier
                    .padding(if (backButtonActive) 0.dp else 16.dp)
                    .align(Alignment.CenterVertically),
                text = headerText,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }


    }
}