package edu.ucne.angel_paredes_ap2_p2.Domain.UseCase

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Repository.GastoRepository
import javax.inject.Inject

class GetGastosUseCase @Inject constructor(
    private val repo: GastoRepository
) {
    operator fun invoke() = repo.getGastos()
}
