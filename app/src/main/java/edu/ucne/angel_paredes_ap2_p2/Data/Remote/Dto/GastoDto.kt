package edu.ucne.angel_paredes_ap2_p2.Data.Remote.Dto

import com.google.gson.annotations.SerializedName

data class GastoDto(
    @SerializedName("gastoId") val gastoId: Int?,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("monto") val monto: Double,
    @SerializedName("fecha") val fecha: String
)
