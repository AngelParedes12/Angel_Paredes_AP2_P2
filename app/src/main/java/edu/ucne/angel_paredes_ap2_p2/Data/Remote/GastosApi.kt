package edu.ucne.angel_paredes_ap2_p2.Data.Remote.Dto.GastosDto

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Dto.GastoDto
import retrofit2.Response
import retrofit2.http.*

interface GastosApi {
    @GET("api/Gastos")
    suspend fun getGastos(): List<GastoDto>

    @GET("api/Gastos/{id}")
    suspend fun getGasto(@Path("id") id: Int): GastoDto

    @POST("api/Gastos")
    suspend fun postGasto(@Body gasto: GastoDto): Response<GastoDto>

    @PUT("api/Gastos/{id}")
    suspend fun putGasto(@Path("id") id: Int, @Body gasto: GastoDto): Response<Unit>
}
