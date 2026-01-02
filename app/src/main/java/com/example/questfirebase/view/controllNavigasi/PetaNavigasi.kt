package com.example.questfirebase.view.controllNavigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questfirebase.view.HalamanEntry
import com.example.questfirebase.view.HalamanHome
import com.example.questfirebase.view.route.DestinasiDetail
import com.example.questfirebase.view.route.DestinasiEntry
import com.example.questfirebase.view.route.DestinasiHome

@Composable
fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(
        navController = navController,
        modifier = modifier
    )
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HalamanHome(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                navigatetoItemUpdate = {
                    navController.navigate("${DestinasiDetail.route}/$it")
                }
            )
        }

        composable(DestinasiEntry.route) {
            HalamanEntry(
                navigateBack = {
                    navController.navigate(DestinasiHome.route)
                }
            )
        }
    }
}
