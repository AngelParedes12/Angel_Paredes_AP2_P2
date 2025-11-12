package edu.ucne.angel_paredes_ap2_p2.Domain.UseCase

import edu.ucne.angel_paredes_ap2_p2.Domain.Repository.GastoRepository
import javax.inject.Inject

class GetGastoUseCase @Inject constructor(
    val repository: GastoRepository
) {
    suspend operator fun invoke() = repository.getGastos()
}