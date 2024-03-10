package com.neolife.homm3guide

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.neolife.homm3guide.screen.Screen
import com.neolife.homm3guide.screen.aboutApp.AboutAppScreen
import com.neolife.homm3guide.screen.aboutCreator.AboutAppCreatorScreen
import com.neolife.homm3guide.screen.home.HomeScreen
import com.neolife.homm3guide.screen.settings.SettingsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        enterTransition = { fadeIn(animationSpec = tween(100)) + slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left,tween(150)) },
        exitTransition = { fadeOut(animationSpec = tween(300)) + slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right,tween(200)) },
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.AboutAppCreator.route) {
            AboutAppCreatorScreen(navController = navController)
        }

        composable(route = Screen.AboutAppScreen.route) {
            AboutAppScreen(navController = navController)
        }

        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen(navController = navController)
        }
    }
}