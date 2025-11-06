package edu.ucne.angel_paredes_ap2_p2.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavHost(navController: androidx.navigation.NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.ListGasto.route,
        modifier = modifier
    ) {
        composable(Screen.ListGasto.route) { ListGastoScreen(navController = navController) }
        composable(
            route = Screen.EditGasto.route,
            arguments = listOf(navArgument(Screen.EditGasto.ARG) { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt(Screen.EditGasto.ARG)
            EditGastoScreen(navController = navController, gastoId = id)
        }
    }
}
