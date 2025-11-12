package edu.ucne.angel_paredes_ap2_p2.Data.Remote

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Api.GastosApiService
import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Dto.GastosDto
import javax.inject.Inject

class GastoRemoteDataSource @Inject constructor(
    private val api: GastosApiService
) {
    suspend fun getGastos(): Resource<List<GastosDto>> = try {
        val resp = api.getGastos()
        if (resp.isSuccessful) {
            val body = resp.body()
            if (body != null) Resource.Success(body)
            else Resource.Error("Respuesta vacía")
        } else {
            Resource.Error("Error ${resp.code()}: ${resp.message()}")
        }
    } catch (e: Exception) {
        Resource.Error("Error: ${e.localizedMessage ?: "Ocurrió un error"}")
    }

    suspend fun postGasto(request: GastosDto): Resource<GastosDto> = try {
        val resp = api.postGasto(request)
        if (resp.isSuccessful) {
            val body = resp.body()
            if (body != null) Resource.Success(body)
            else Resource.Error("Respuesta vacía")
        } else {
            Resource.Error("Error ${resp.code()}: ${resp.message()}")
        }
    } catch (e: Exception) {
        Resource.Error("Error: ${e.localizedMessage ?: "Ocurrió un error"}")
    }

    suspend fun putGasto(id: Int, request: GastosDto): Resource<Unit> = try {
        val resp = api.putGasto(id, request)
        if (resp.isSuccessful) {
            Resource.Success(Unit)
        } else {
            Resource.Error("Error ${resp.code()}: ${resp.message()}")
        }
    } catch (e: Exception) {
        Resource.Error("Error: ${e.localizedMessage ?: "Ocurrió un error"}")
    }

    suspend fun getGastoById(id: Int): Resource<GastosDto> = try {
        val resp = api.getGastoById(id)
        if (resp.isSuccessful) {
            val body = resp.body()
            if (body != null) Resource.Success(body)
            else Resource.Error("Respuesta vacía")
        } else {
            Resource.Error("Error ${resp.code()}: ${resp.message()}")
        }
    } catch (e: Exception) {
        Resource.Error("Error: ${e.localizedMessage ?: "Ocurrió un error"}")
    }
}
