package edu.ucne.angel_paredes_ap2_p2.Domain.Model

data class Gasto(
    val gastoId: Int = 0,
    val fecha: String,
    val suplidor: String?,
    val ncf: String?,
    val itbis: Double,
    val monto: Double
)