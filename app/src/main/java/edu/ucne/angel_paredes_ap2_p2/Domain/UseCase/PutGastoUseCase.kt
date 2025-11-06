package edu.ucne.angel_paredes_ap2_p2.Domain.UseCase

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Repository.GastoRepository
import edu.ucne.angel_paredes_ap2_p2.Domain.Gasto
import edu.ucne.angel_paredes_ap2_p2.Domain.Validation.GastoValidator
import javax.inject.Inject

class PutGastoUseCase @Inject constructor(
    private val repo: GastoRepository,
    private val validator: GastoValidator
) {
    suspend operator fun invoke(id: Int, g: Gasto): Result<Boolean> {
        if (id <= 0) return Result.failure(IllegalArgumentException("ID inválido"))
        val vd = validator.validateDescripcion(g.descripcion)
        val vm = validator.validateMonto(g.monto.toString())
        val vf = validator.validateFecha(g.fecha)
        if (!vd.isValid) return Result.failure(IllegalArgumentException(vd.errorMessage))
        if (!vm.isValid) return Result.failure(IllegalArgumentException(vm.errorMessage))
        if (!vf.isValid) return Result.failure(IllegalArgumentException(vf.errorMessage))
        return runCatching { repo.putGasto(id, g) }
    }
}
