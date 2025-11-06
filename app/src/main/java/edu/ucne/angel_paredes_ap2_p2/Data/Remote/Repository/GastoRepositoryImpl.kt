package edu.ucne.angel_paredes_ap2_p2.Data.Remote.Repository

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.GastoRemoteDataSource
import edu.ucne.angel_paredes_ap2_p2.Domain.Gasto
import edu.ucne.angel_paredes_ap2_p2.Mapper.toDto
import edu.ucne.angel_paredes_ap2_p2.Mapper.toGasto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GastoRepositoryImpl @Inject constructor(
    private val ds: GastoRemoteDataSource
) : GastoRepository {
    override fun getGastos(): Flow<List<Gasto>> = flow {
        emit(ds.getGastos().map { it.toGasto() })
    }
    override suspend fun getGasto(id: Int): Gasto? = ds.getGasto(id).toGasto()
    override suspend fun postGasto(gasto: Gasto): Gasto = ds.postGasto(gasto.toDto()).body()!!.toGasto()
    override suspend fun putGasto(id: Int, gasto: Gasto): Boolean = ds.putGasto(id, gasto.toDto()).isSuccessful
}
