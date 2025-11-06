package edu.ucne.angel_paredes_ap2_p2.Domain.Validation

import javax.inject.Inject

class GastoValidator @Inject constructor() {
    fun validateDescripcion(v: String) = if (v.isBlank() || v.length < 3 || v.length > 80) ValidationResult(false, "Descripción inválida") else ValidationResult(true)
    fun validateMonto(v: String): ValidationResult {
        val m = v.toDoubleOrNull()
        return if (m == null || m <= 0.0) ValidationResult(false, "Monto inválido") else ValidationResult(true)
    }
    fun validateFecha(v: String) = if (v.isBlank()) ValidationResult(false, "Fecha requerida") else ValidationResult(true)
}