package com.abassey.hemnettest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abassey.hemnettest.ui.details.AdvertDetailsScreen
import com.abassey.hemnettest.ui.find.FindScreen
import com.abassey.hemnettest.ui.theme.HemnetTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HemnetTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HemnetApp()
                }
            }
        }
    }
}

@Composable
fun HemnetApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = DestinationScreen.Find.route) {
        composable(DestinationScreen.Find.route) {
            FindScreen(navController = navController, selectAdvert = { advertId ->
                navController.navigate("${DestinationScreen.AdvertDetails.route}/$advertId")

            })
        }


        composable(route = DestinationScreen.AdvertDetails.routeWithArgument,
            arguments = listOf(
                navArgument(DestinationScreen.AdvertDetails.argument) { type = NavType.StringType }
            )
        ) { navBackStackEntry ->
            val advertId =
                navBackStackEntry.arguments?.getString(DestinationScreen.AdvertDetails.argument)
                    ?: return@composable
            AdvertDetailsScreen(advertId = advertId, navController = navController)
        }
    }
}

sealed class DestinationScreen(val route: String) {
    object Find : DestinationScreen("Find")

    object AdvertDetails : DestinationScreen("AdvertDetails") {
        const val routeWithArgument: String = "AdvertDetails/{advertId}"

        const val argument: String = "advertId"
    }
}