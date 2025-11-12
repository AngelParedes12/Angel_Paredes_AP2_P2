package edu.ucne.angel_paredes_ap2_p2.Data.Remote.Dto


data class GastoDto(
val fecha: String,
val suplidor: String?,
val ncf: String?,
val itbis: Double,
val monto: Double
)