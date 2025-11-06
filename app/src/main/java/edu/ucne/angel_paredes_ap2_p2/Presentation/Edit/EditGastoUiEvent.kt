package edu.ucne.angel_paredes_ap2_p2.Presentation.Edit

interface EditGastoUiEvent {
    data class descripcionChanged(val v: String): EditGastoUiEvent
    data class montoChanged(val v: String): EditGastoUiEvent
    data class fechaChanged(val v: String): EditGastoUiEvent
    data class load(val id: Int?): EditGastoUiEvent
    data object save: EditGastoUiEvent
}
