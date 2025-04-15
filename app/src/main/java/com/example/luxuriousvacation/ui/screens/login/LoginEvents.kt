package com.example.luxuriousvacation.ui.screens.login


sealed class LoginEvent {
    data class PhoneChanged(val value: String) : LoginEvent()
    data class PasswordChanged(val value: String) : LoginEvent()
    object LoginClicked : LoginEvent()
}