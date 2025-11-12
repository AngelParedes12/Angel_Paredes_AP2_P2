package edu.ucne.angel_paredes_ap2_p2.Data.Remote.Dto

import kotlinx.serialization.Serializable

@Serializable
data class GastosDto(
    val gastoId: Int = 0,
    val fecha: String = "",
    val suplidor: String? = null,
    val ncf: String? = null,
    val itbis: Double = 0.0,
    val monto: Double = 0.0
)
