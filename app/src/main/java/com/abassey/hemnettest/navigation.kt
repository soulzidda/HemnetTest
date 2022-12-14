package com.abassey.hemnettest

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.abassey.hemnettest.ui.details.DetailsScreen
import com.abassey.hemnettest.ui.find.FindScreen
import com.abassey.hemnettest.ui.shared.AdvertViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HemnetApp() {
    val navController = rememberAnimatedNavController()
    val springSpec = spring<IntOffset>(
        dampingRatio = Spring.DampingRatioNoBouncy,
        stiffness = 200f
    )

    AnimatedNavHost(
        navController = navController,
        startDestination = DestinationScreen.Find.route,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { 1000 }, animationSpec = springSpec,
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -1000 }, animationSpec = springSpec
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -1000 }, animationSpec = springSpec
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { 1000 }, animationSpec = springSpec
            )
        },
        modifier = Modifier,
    ) {
        composable(DestinationScreen.Find.route) {
            val advertViewModel = hiltViewModel<AdvertViewModel>()
            FindScreen(viewModel = advertViewModel,
                navController = navController,
                selectAdvert = { advertId ->
                    navController.navigate("${DestinationScreen.AdvertDetails.route}/$advertId")
                })
        }
        composable(
            route = DestinationScreen.AdvertDetails.routeWithArgument,
            arguments = listOf(navArgument(
                DestinationScreen.AdvertDetails.argument
            ) { type = NavType.StringType })
        ) { navBackStackEntry ->
            val advertViewModel = hiltViewModel<AdvertViewModel>()
            val advertId =
                navBackStackEntry.arguments?.getString(DestinationScreen.AdvertDetails.argument)
                    ?: return@composable
            DetailsScreen(
                viewModel = advertViewModel, advertId = advertId, navController = navController
            )
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