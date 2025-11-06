package edu.ucne.angel_paredes_ap2_p2.Mapper

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Dto.GastoDto
import edu.ucne.angel_paredes_ap2_p2.Di.Gasto

fun GastoDto.toGasto(): edu.ucne.angel_paredes_ap2_p2.Domain.Gasto = Gasto(
    gastoId = gastoId ?: 0,
    descripcion = descripcion,
    monto = monto,
    fecha = fecha
)

fun Gasto.toDto(): GastoDto = GastoDto(
    gastoId = if (gastoId == 0) null else gastoId,
    descripcion = descripcion,
    monto = monto,
    fecha = fecha
)