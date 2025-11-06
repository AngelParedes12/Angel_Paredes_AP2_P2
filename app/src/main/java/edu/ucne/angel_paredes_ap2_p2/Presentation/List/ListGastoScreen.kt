package edu.ucne.angel_paredes_ap2_p2.Presentation.List

import android.view.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import edu.ucne.angel_paredes_ap2_p2.Navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListGastoScreen(navController: NavController, vm: ListGastoViewModel = hiltViewModel()) {
    val state by vm.uiState.collectAsStateWithLifecycle()
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Gastos") }, windowInsets = WindowInsets(0.dp)) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.EditGasto.createRoute(0)) }) {
                Icon(Icons.Default.Add, null)
            }
        }
    ) { inner ->
        Box(Modifier.padding(inner).fillMaxSize()) {
            if (state.isLoading) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.gastos, key = { it.gastoId }) { g ->
                        GastoItem(g) { navController.navigate(Screen.EditGasto.createRoute(g.gastoId)) }
                    }
                }
            }
        }
    }
}

@Composable
fun GastoItem(g: Gasto, onClick: () -> Unit) {
    Card(Modifier.fillMaxWidth().clickable { onClick() }) {
        Column(Modifier.fillMaxWidth().padding(16.dp)) {
            Text(g.descripcion, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(4.dp))
            Text("Monto: ${g.monto}")
            Spacer(Modifier.height(2.dp))
            Text("Fecha: ${g.fecha}")
        }
    }
}
