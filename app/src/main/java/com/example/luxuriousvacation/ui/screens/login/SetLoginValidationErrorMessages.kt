package com.example.luxuriousvacation.ui.screens.login

import com.example.data.model.ValidationError
import com.example.luxuriousvacation.R

fun ValidationError?.setMessage(): Int? {
    return when(this) {
        ValidationError.InvalidEmptyPasswordLength -> R.string.please_enter_password
        ValidationError.InvalidPasswordLength -> R.string.password_should_be_at_least_8_characters_long
        ValidationError.InvalidEmptyPhoneNumber -> R.string.please_enter_phone_number
        ValidationError.InvalidPhoneNumberLength -> R.string.phone_number_must_be_btweeen_9_and_10_digits
        else -> null
    }
}