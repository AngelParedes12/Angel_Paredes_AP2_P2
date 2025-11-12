package edu.ucne.angel_paredes_ap2_p2.Data.Remote.Repository

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.GastoRemoteDataSource
import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Resource
import edu.ucne.angel_paredes_ap2_p2.Domain.Model.Gasto
import edu.ucne.angel_paredes_ap2_p2.Domain.Repository.GastoRepository
import edu.ucne.angel_paredes_ap2_p2.Mapper.toDomain
import edu.ucne.angel_paredes_ap2_p2.Mapper.toRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GastoRepositoryImpl @Inject constructor(
    val remoteDataSource: GastoRemoteDataSource
): GastoRepository {
    override suspend fun getGastos(): Flow<List<Gasto>> = flow {
        when (val result = remoteDataSource.getGastos()) {
            is Resource.Success -> {
                val list = result.data?.map { it.toDomain() } ?: emptyList()
                emit(list)
            }
            is Resource.Error -> {
                emit(emptyList())
            }
            else -> {
                emit(emptyList())
            }
        }
    }

    override suspend fun postGasto(gasto: Gasto): Resource<Gasto?> {
        val result = remoteDataSource.postGasto(gasto.toRequest())
        return when (result) {
            is Resource.Success -> {
                val response = result.data
                Resource.Success(response?.toDomain())
            }
            is Resource.Error -> {
                Resource.Error(result.message ?: "Error")
            }
            else -> {
                Resource.Error("Error")
            }
        }
    }

    override suspend fun putGasto(id: Int, gasto: Gasto): Resource<Unit>{
        val result = remoteDataSource.putGasto(id, gasto.toRequest())
        return when(result){
            is Resource.Success -> {
                Resource.Success(Unit)
            }
            is Resource.Error -> {
                Resource.Error(result.message ?: "Error")
            }
            else -> {
                Resource.Error("Error")
            }
        }
    }

    override suspend fun getGastoById(id: Int): Resource<Gasto?>{
        val result = remoteDataSource.getGastoById(id)
        return when(result){
            is Resource.Success -> {
                val gasto = result.data
                Resource.Success(gasto?.toDomain())
            }
            is Resource.Error -> {
                Resource.Error(result.message ?: "Error")
            }
            else -> {
                Resource.Error("Error")
            }
        }

    }
}