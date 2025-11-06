package edu.ucne.angel_paredes_ap2_p2.Navigation

sealed class Screen(val route: String) {
    data object ListGasto : Screen("list_gasto_screen")
    data object EditGasto : Screen("edit_gasto_screen/{gastoId}") {
        const val ARG = "gastoId"
        fun createRoute(id: Int) = "edit_gasto_screen/$id"
    }
}