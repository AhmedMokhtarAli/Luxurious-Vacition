package com.example.luxuriousvacation.ui.screens.signup


sealed class SignupEvent {
    data class PhoneChanged(val value: String) : SignupEvent()
    data class EmailChanged(val value: String) : SignupEvent()
    data class PasswordChanged(val value: String) : SignupEvent()
    data class CityChanged(val value: String) : SignupEvent()
    data class TermsClicked(val value: Boolean) : SignupEvent()
    object SignupEventClicked : SignupEvent()
}