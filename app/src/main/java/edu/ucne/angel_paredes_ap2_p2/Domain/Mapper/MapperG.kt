package edu.ucne.angel_paredes_ap2_p2.Domain.Mapper

import java.text.SimpleDateFormat
import java.util.Locale



fun String.MapperG(): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale("es"))
        val date = inputFormat.parse(this)
        date?.let { outputFormat.format(it) } ?: this
    } catch (e: Exception) {
        this
    }
}