package edu.ucne.angel_paredes_ap2_p2.Data.Remote.Repository
import kotlinx.coroutines.flow.Flow
interface GastoRepository {
    fun getGastos(): Flow<List<Gasto>>
    suspend fun getGasto(id: Int): Gasto?
    suspend fun postGasto(gasto: Gasto): Gasto
    suspend fun putGasto(id: Int, gasto: Gasto): Boolean
}
