package edu.ucne.angel_paredes_ap2_p2.Presentation.Edit

data class EditGastoUiState(
    val gastoId: Int? = 0,
    val descripcion: String = "",
    val monto: String = "",
    val fecha: String = "",
    val descripcionError: String? = null,
    val montoError: String? = null,
    val fechaError: String? = null,
    val isSaving: Boolean = false,
    val isSaved: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val canUpdate: Boolean = false
)