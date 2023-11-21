package com.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.screens.details.DetailsScreen
import com.screens.home.HomeScreen

@Composable
fun movieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            //here we pass where this should lead us to
            HomeScreen(navController = navController)
        }
        composable(
            MovieScreens.DetailsScreen.name + "/{movie}/{ticketPrice}",
            arguments = listOf(
                navArgument(name = "movie") { type = NavType.StringType },
                navArgument(name = "ticketPrice") { type = NavType.IntType })
        ) { backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie"),
                backStackEntry.arguments?.getInt("ticketPrice")
            )
        }
    }
}