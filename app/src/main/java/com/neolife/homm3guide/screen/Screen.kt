package com.neolife.homm3guide.screen

sealed class Screen(val route: String)
{
    data object HomeScreen: Screen("HomeScreen")
    data object AboutAppCreator  : Screen("AboutAppCreator")
    data object AboutAppScreen: Screen("AboutAppScreen")
    data object SettingsScreen: Screen("SettingsScreen")
    data object TableSettingsScreen: Screen("tableSettingsScreen")

    data object AddPostScreen: Screen("editPostScreen")

    data object EditPostScreen: Screen("editPostScreen/{post_id}")

    data object PostScreen: Screen("postScreen/{post_id}")
}