package edu.ucne.angel_paredes_ap2_p2.Presentation

import edu.ucne.angel_paredes_ap2_p2.Domain.Model.Gasto

data class GastoUiState(
    val isLoading: Boolean = false,
    val Gastos: List<Gasto> = emptyList(),
    val id: Int = 0,
    val fecha: String = "",
    val fechaError: String? = null,
    val suplidor: String = "",
    val suplidorError: String? = null,
    val ncf: String = "",
    val ncfError: String? = null,
    val itbis: Double = 0.00,
    val itbisError: String? = null,
    val monto: Double = 0.00,
    val montoError: String? = null,
    val showSheet: Boolean = false,
    val userMessage: String = "",
    val isEditable: Boolean = false
)