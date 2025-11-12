package edu.ucne.angel_paredes_ap2_p2.Data.Remote.Api

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Dto.GastosDto
import retrofit2.Response
import retrofit2.http.*

interface GastosApiService {
    @GET("api/Gastos")
    suspend fun getGastos(): Response<List<GastosDto>>

    @GET("api/Gastos/{id}")
    suspend fun getGastoById(@Path("id") id: Int): Response<GastosDto>

    @POST("api/Gastos")
    suspend fun postGasto(@Body gasto: GastosDto): Response<GastosDto>

    @PUT("api/Gastos/{id}")
    suspend fun putGasto(
        @Path("id") id: Int,
        @Body gasto: GastosDto
    ): Response<Unit>

    @DELETE("api/Gastos/{id}")
    suspend fun deleteGasto(@Path("id") id: Int): Response<Unit>
}
