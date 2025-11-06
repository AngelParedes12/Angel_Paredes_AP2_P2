package edu.ucne.angel_paredes_ap2_p2.Presentation.Edit



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.angel_paredes_ap2_p2.Di.Gasto
import edu.ucne.angel_paredes_ap2_p2.Domain.UseCase.PostGastoUseCase
import edu.ucne.angel_paredes_ap2_p2.Domain.UseCase.PutGastoUseCase
import edu.ucne.angel_paredes_ap2_p2.Domain.Validation.GastoValidator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditGastoViewModel @Inject constructor(
    private val getGasto: GetGastoUseCase,
    private val postGasto: PostGastoUseCase,
    private val putGasto: PutGastoUseCase,
    private val validator: GastoValidator
) : ViewModel() {

    private val _state = MutableStateFlow(EditGastoUiState())
    val state: StateFlow<EditGastoUiState> = _state.asStateFlow()

    fun onEvent(e: EditGastoUiEvent) {
        when (e) {
            is EditGastoUiEvent.load -> onLoad(e.id)
            is EditGastoUiEvent.descripcionChanged -> _state.update { it.copy(descripcion = e.v, descripcionError = null) }
            is EditGastoUiEvent.montoChanged -> _state.update { it.copy(monto = e.v, montoError = null) }
            is EditGastoUiEvent.fechaChanged -> _state.update { it.copy(fecha = e.v, fechaError = null) }
            EditGastoUiEvent.save -> onSave()
        }
    }

    private fun onLoad(id: Int?) {
        if (id == null || id == 0) {
            _state.update { it.copy(gastoId = null, descripcion = "", monto = "", fecha = "", canUpdate = false) }
            return
        }
        _state.update { it.copy(isLoading = true, errorMessage = null) }
        viewModelScope.launch {
            try {
                val g = getGasto(id)
                if (g != null) {
                    _state.update { it.copy(gastoId = g.gastoId, descripcion = g.descripcion, monto = g.monto.toString(), fecha = g.fecha, isLoading = false, canUpdate = true) }
                } else {
                    _state.update { it.copy(isLoading = false, errorMessage = "No encontrado", canUpdate = false, gastoId = null) }
                }
            } catch (ex: Exception) {
                _state.update { it.copy(isLoading = false, errorMessage = ex.message ?: "Error") }
            }
        }
    }

    private fun onSave() {
        val d = _state.value.descripcion
        val m = _state.value.monto
        val f = _state.value.fecha
        val vd = validator.validateDescripcion(d)
        val vm = validator.validateMonto(m)
        val vf = validator.validateFecha(f)
        if (!vd.isValid || !vm.isValid || !vf.isValid) {
            _state.update { it.copy(descripcionError = vd.errorMessage, montoError = vm.errorMessage, fechaError = vf.errorMessage) }
            return
        }
        viewModelScope.launch {
            _state.update { it.copy(isSaving = true, errorMessage = null) }
            val id = _state.value.gastoId ?: 0
            val gasto = Gasto(gastoId = id, descripcion = d, monto = m.toDouble(), fecha = f)
            if (id == 0) {
                val r = postGasto(gasto)
                r.onSuccess {
                    _state.update { s -> s.copy(isSaving = false, isSaved = true, gastoId = it.gastoId, canUpdate = true) }
                }.onFailure { ex ->
                    _state.update { s -> s.copy(isSaving = false, errorMessage = ex.message ?: "Error") }
                }
            } else {
                val r = putGasto(id, gasto)
                r.onSuccess { ok ->
                    _state.update { s -> s.copy(isSaving = false, isSaved = ok) }
                }.onFailure { ex ->
                    _state.update { s -> s.copy(isSaving = false, errorMessage = ex.message ?: "Error") }
                }
            }
        }
    }
}
