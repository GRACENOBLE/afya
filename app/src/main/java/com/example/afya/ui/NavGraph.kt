package com.example.afya.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.afya.ui.home.HomeScreen
import com.example.afya.ui.publications.PublicationsScreen
import com.example.afya.ui.settings.SettingsScreen
import com.example.afya.ui.store.StoreScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home" // This is the screen that will be shown first
    ) {
        composable("home") {
            // This is the Home screen content
            HomeScreen(navController)
        }
        composable("store") {
            // This is the Store screen content
            StoreScreen(navController)
        }
        composable("publications") {
            // This is the Publications screen content
            PublicationsScreen(navController)
        }
        composable("settings") {
            // This is the Settings screen content
            SettingsScreen(navController)
        }
    }
}