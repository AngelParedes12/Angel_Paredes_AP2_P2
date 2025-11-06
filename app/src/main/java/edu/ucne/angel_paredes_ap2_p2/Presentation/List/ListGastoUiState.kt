package edu.ucne.angel_paredes_ap2_p2.Presentation.List

import edu.ucne.angel_paredes_ap2_p2.Di.Gasto


data class ListGastoUiState(
    val gastos: List<Gasto> = emptyList(),
    val isLoading: Boolean = false
)
