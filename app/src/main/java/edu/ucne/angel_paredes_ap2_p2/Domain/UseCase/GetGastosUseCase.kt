package edu.ucne.angel_paredes_ap2_p2.Domain.UseCase

import edu.ucne.angel_paredes_ap2_p2.Domain.Repository.GastoRepository
import javax.inject.Inject

class GetGastosUseCase @Inject constructor(
    val repository: GastoRepository
) {
    suspend operator fun invoke(id: Int) = repository.getGastoById(id)
}