package com.neolife.homm3guide

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.neolife.homm3guide.database.DBHelper
import com.neolife.homm3guide.screen.Screen
import com.neolife.homm3guide.screen.aboutApp.AboutAppScreen
import com.neolife.homm3guide.screen.aboutCreator.AboutAppCreatorScreen
import com.neolife.homm3guide.screen.tableSettings.tableSettingsScreen
import com.neolife.homm3guide.screen.home.HomeScreen
import com.neolife.homm3guide.screen.post.editPostScreen
import com.neolife.homm3guide.screen.post.PostScreen
import com.neolife.homm3guide.screen.settings.SettingsScreen

@Composable
fun Navigation(db: DBHelper) {
    val navController = rememberNavController()

    NavHost(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController, db)
        }
        composable(route = Screen.AboutAppCreator.route) {
            AboutAppCreatorScreen(navController = navController)
        }
        composable(route = Screen.PostScreen.route, arguments = listOf(navArgument("post_id") { type = NavType.IntType })) {
            backStackEntry ->
            backStackEntry.arguments?.getInt("post_id")
                ?.let { PostScreen(navController = navController, db, it) }
        }

        composable(route = Screen.AboutAppScreen.route) {
            AboutAppScreen(navController = navController)
        }

        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen(navController = navController)
        }

        composable(route = Screen.AddPostScreen.route) {
            editPostScreen(navController = navController, db, null)
        }

        composable(route = Screen.EditPostScreen.route, arguments = listOf(navArgument("post_id") { type = NavType.IntType })) {
                backStackEntry ->
            backStackEntry.arguments?.getInt("post_id")
                ?.let { editPostScreen(navController = navController, db, it) }
        }

        composable(route = Screen.TableSettingsScreen.route) {
            tableSettingsScreen(navController = navController)
        }
    }
}