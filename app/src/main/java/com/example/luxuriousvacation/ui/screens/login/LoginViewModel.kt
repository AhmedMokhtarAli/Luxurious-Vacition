package com.example.luxuriousvacation.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aait.commondomain.usecase.ValidatePasswordUseCase
import com.aait.commondomain.usecase.ValidatePhoneUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validatePhoneUseCase: ValidatePhoneUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
) : ViewModel() {
    var uiState by mutableStateOf(LogInUiState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.PhoneChanged -> uiState = uiState.copy(phone = event.value)
            is LoginEvent.PasswordChanged -> uiState = uiState.copy(password = event.value)
            is LoginEvent.LoginClicked -> validate()
        }
    }

    private fun validate() {
        val phoneResult = validatePhoneUseCase(uiState.phone)
        val passwordResult = validatePasswordUseCase(uiState.password)

        val hasError = listOf(
            phoneResult,
            passwordResult
        ).any { !it.isSuccess }

        if (hasError) {
            uiState = uiState.copy(
                phoneErrorResId = phoneResult.validationError?.setMessage(),
                passwordErrorResId = passwordResult.validationError?.setMessage(),
                isFormValid = false
            )
        } else {
            uiState = uiState.copy(
                phoneErrorResId = null,
                passwordErrorResId = null,
                isFormValid = true
            )
        }
    }
}