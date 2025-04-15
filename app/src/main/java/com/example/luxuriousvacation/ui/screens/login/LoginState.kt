package com.example.luxuriousvacation.ui.screens.login

data class LogInUiState(
    val phone: String = "",
    val phoneErrorResId: Int? = null,
    val password: String = "",
    val passwordErrorResId: Int? = null,
    val isFormValid: Boolean = false
)
