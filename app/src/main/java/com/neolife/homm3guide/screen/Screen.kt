package com.neolife.homm3guide.screen

sealed class Screen(val route: String)
{
    data object HomeScreen: Screen("HomeScreen")
    data object AboutAppCreator  : Screen("AboutAppCreator")
    data object AboutAppScreen: Screen("AboutAppScreen")
    data object SettingsScreen: Screen("SettingsScreen")
}