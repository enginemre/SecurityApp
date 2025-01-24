package com.engin.securityapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.engin.securityapp.ui.screen.DataStoreEncryptionScreen
import com.engin.securityapp.ui.screen.HomeScreen
import com.engin.securityapp.ui.screen.encryptionScreenRoute
import com.engin.securityapp.ui.screen.homeScreenRoute

@Composable
fun SecurityAppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = homeScreenRoute
    ){
        composable(
            route = homeScreenRoute
        ){
            HomeScreen(
                navigateEncryptionScreen = {
                    navController.navigate(encryptionScreenRoute)
                }
            )
        }
        composable(
            route = encryptionScreenRoute
        ) {
            DataStoreEncryptionScreen()
        }
    }
}