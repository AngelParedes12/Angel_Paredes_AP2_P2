package edu.ucne.angel_paredes_ap2_p2.Domain.Repository

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Resource
import edu.ucne.angel_paredes_ap2_p2.Domain.Model.Gasto
import kotlinx.coroutines.flow.Flow

interface GastoRepository {
    suspend fun getGastos(): Flow<List<Gasto>>
    suspend fun postGasto(gasto: Gasto): Resource<Gasto?>
    suspend fun putGasto(id: Int, gasto: Gasto): Resource<Unit>
    suspend fun getGastoById(id: Int): Resource<Gasto?>
}