package edu.ucne.angel_paredes_ap2_p2.Presentation.List

import edu.ucne.angel_paredes_ap2_p2.Domain.UseCase.GetGastosUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListGastoViewModel @Inject constructor(
    private val getGastos: GetGastosUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(ListGastoUiState())
    val uiState: StateFlow<ListGastoUiState> = _uiState.asStateFlow()

    init { load() }

    fun load() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            getGastos().collect { list ->
                _uiState.update { it.copy(gastos = list, isLoading = false) }
            }
        }
    }
}
