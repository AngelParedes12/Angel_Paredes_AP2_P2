package edu.ucne.angel_paredes_ap2_p2.Domain.UseCase

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Resource
import edu.ucne.angel_paredes_ap2_p2.Domain.Repository.GastoRepository
import edu.ucne.angel_paredes_ap2_p2.Domain.Model.Gasto
import javax.inject.Inject
import edu.ucne.angel_paredes_ap2_p2.Domain.Validation.GastoValidator

class PostGastoUseCase @Inject constructor(
    private val repository: GastoRepository
) {
    suspend operator fun invoke(id: Int = 0, gasto: Gasto): Resource<Gasto?> {
        return if (id == 0) {
            repository.postGasto(gasto)
        } else {
            when (repository.putGasto(id, gasto)) {
                is Resource.Success -> Resource.Success(null)
                is Resource.Error -> Resource.Error("Error al actualizar el gasto")
                else -> Resource.Error("Error desconocido")
            }
        }
    }
}