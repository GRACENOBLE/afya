package com.example.afya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileOpen // Corrected import
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.afya.ui.theme.AfyaTheme
import com.example.afya.ui.home.HomeScreen
import com.example.afya.ui.store.StoreScreen       // Updated import
import com.example.afya.ui.publications.PublicationsScreen // Updated import
import com.example.afya.ui.settings.SettingsScreen     // Updated import

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // installSplashScreen() // Uncomment if splash screen is implemented
        setContent {
            AfyaTheme {
                MainScreenView()
            }
        }
    }
}

@Composable
fun MainScreenView(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        AppNavigationHost(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun AppNavigationHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        composable("home") {
            HomeScreen(navController = navController) // Updated call
        }
        composable("store") {
            StoreScreen(navController = navController)      // Updated call
        }
        composable("publications") {
            PublicationsScreen(navController = navController) // Updated call
        }
        composable("settings") {
            SettingsScreen(navController = navController)   // Updated call
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = {
                if (currentRoute != "home") {
                    navController.navigate("home") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = currentRoute == "store",
            onClick = {
                if (currentRoute != "store") {
                    navController.navigate("store") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Store") },
            label = { Text("Store") }
        )
        NavigationBarItem(
            selected = currentRoute == "publications",
            onClick = {
                if (currentRoute != "publications") {
                    navController.navigate("publications"){
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            icon = { Icon(imageVector = Icons.Filled.FileOpen, contentDescription = "Publications") }, // Icon reverted
            label = { Text("Publications") }
        )
        NavigationBarItem(
            selected = currentRoute == "settings",
            onClick = {
                if (currentRoute != "settings") {
                    navController.navigate("settings") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings") },
            label = { Text("Settings") }
        )
    }
}

// Greeting and MyScreenContent are kept for potential use elsewhere or if you want to revert
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreenView() {
    AfyaTheme {
        MainScreenView()
    }
}
