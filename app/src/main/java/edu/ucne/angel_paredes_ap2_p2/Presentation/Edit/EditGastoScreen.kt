package edu.ucne.angel_paredes_ap2_p2.Presentation.Edit


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditGastoScreen(navController: NavController, gastoId: Int?, vm: EditGastoViewModel = hiltViewModel()) {
    LaunchedEffect(gastoId) { vm.onEvent(EditGastoUiEvent.load(gastoId)) }
    val state by vm.state.collectAsStateWithLifecycle()
    val title = if (state.canUpdate) "Editar Gasto" else "Nuevo Gasto"
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                },
                windowInsets = WindowInsets(0.dp)
            )
        }
    ) { inner ->
        Column(Modifier.padding(inner).padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            OutlinedTextField(
                value = state.descripcion,
                onValueChange = { vm.onEvent(EditGastoUiEvent.descripcionChanged(it)) },
                label = { Text("Descripción") },
                isError = state.descripcionError != null,
                modifier = Modifier.fillMaxWidth()
            )
            if (state.descripcionError != null) Text(state.descripcionError ?: "", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
            OutlinedTextField(
                value = state.monto,
                onValueChange = { vm.onEvent(EditGastoUiEvent.montoChanged(it)) },
                label = { Text("Monto") },
                isError = state.montoError != null,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.fillMaxWidth()
            )
            if (state.montoError != null) Text(state.montoError ?: "", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
            OutlinedTextField(
                value = state.fecha,
                onValueChange = { vm.onEvent(EditGastoUiEvent.fechaChanged(it)) },
                label = { Text("Fecha") },
                isError = state.fechaError != null,
                modifier = Modifier.fillMaxWidth()
            )
            if (state.fechaError != null) Text(state.fechaError ?: "", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
            Button(
                onClick = { vm.onEvent(EditGastoUiEvent.save) },
                enabled = !state.isSaving,
                modifier = Modifier.fillMaxWidth()
            ) { Text("Guardar") }
        }
    }
}