package edu.ucne.angel_paredes_ap2_p2.Mapper

import edu.ucne.angel_paredes_ap2_p2.Data.Remote.Dto.GastosDto
import edu.ucne.angel_paredes_ap2_p2.Domain.Model.Gasto

fun GastosDto.toDomain(): Gasto = Gasto(
    gastoId = this.gastoId,
    fecha = this.fecha,
    suplidor = this.suplidor,
    ncf = this.ncf,
    itbis = this.itbis,
    monto = this.monto
)

fun Gasto.toRequest(): GastosDto = GastosDto(
    gastoId = this.gastoId,
    fecha = this.fecha,
    suplidor = this.suplidor,
    ncf = this.ncf,
    itbis = this.itbis,
    monto = this.monto
)
