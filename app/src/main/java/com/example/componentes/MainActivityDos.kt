package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivityDos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaDos()
        }
    }
}

@Composable
fun PantallaDos() {
    var texto by rememberSaveable { mutableStateOf("") }
    var estaMarcado by rememberSaveable { mutableStateOf(false) }
    var estaEncendido by rememberSaveable { mutableStateOf(false) }
    var valor by rememberSaveable { mutableStateOf(0.5f) }
    var opcionSeleccionada by rememberSaveable { mutableStateOf("Opcion1") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = texto,
            onValueChange = { nuevoTexto -> texto = nuevoTexto },
            label = { Text("TextField") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = texto,
            onValueChange = { nuevoTexto -> texto = nuevoTexto },
            label = { Text("OutlinedTextField") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Checkbox(
            checked = estaMarcado,
            onCheckedChange = { marcado -> estaMarcado = marcado }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Switch(
            checked = estaEncendido,
            onCheckedChange = { nuevoEstado -> estaEncendido = nuevoEstado }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Slider(
            value = valor,
            onValueChange = { nuevoValor -> valor = nuevoValor },
            valueRange = 0f..1f
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            RadioButton(
                selected = opcionSeleccionada == "Opcion1",
                onClick = { opcionSeleccionada = "Opcion1" }
            )
            RadioButton(
                selected = opcionSeleccionada == "Opcion2",
                onClick = { opcionSeleccionada = "Opcion2" }
            )
        }
    }
}
