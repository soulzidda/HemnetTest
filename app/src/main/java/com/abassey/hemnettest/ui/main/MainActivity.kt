package com.abassey.hemnettest.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.abassey.hemnettest.HemnetApp
import com.abassey.hemnettest.ui.shared.AdvertViewModel
import com.abassey.hemnettest.ui.theme.HemnetTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @VisibleForTesting
    internal val viewModel: AdvertViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HemnetTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    HemnetApp()
                }
            }
        }
    }
}

