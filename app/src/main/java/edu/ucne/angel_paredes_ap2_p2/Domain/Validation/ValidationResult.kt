package edu.ucne.angel_paredes_ap2_p2.Domain.Validation


data class ValidationResult(
    val isValid: Boolean,
    val error: String? = null
)
