package com.example.luxuriousvacation.ui.screens.signup

data class SignupUiState(
    val phone: String = "",
    val phoneErrorResId: Int? = null,
    val password: String = "",
    val passwordErrorResId: Int? = null,
    val city: String = "",
    val cityErrorResId: Int? = null,
    val email: String = "",
    val emailErrorResId: Int? = null,
    val isTermsAccepted: Boolean = false,
    val termsErrorResId: Int? = null,
    val isFormValid: Boolean = false
)
