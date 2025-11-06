package edu.ucne.angel_paredes_ap2_p2.Data.Remote

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Dto.GastoDto
import edu.ucne.angel_paredes_ap2_p2.Data.Remote.GastoRemoteDataSource
import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Dto.GastosDto.GastosApi
import javax.inject.Inject

class GastoRemoteDataSource @Inject constructor(
    private val api: GastosApi
) {
    suspend fun getGastos() = api.getGastos()
    suspend fun getGasto(id: Int) = api.getGasto(id)
    suspend fun postGasto(dto: GastoDto) = api.postGasto(dto)
    suspend fun putGasto(id: Int, dto: GastoDto) = api.putGasto(id, dto)
}
