package com.example.luxuriousvacation.ui.utilis

import com.example.data.model.BaseValidationError
import com.example.luxuriousvacation.R

fun BaseValidationError?.setValidationMessage(): Int? {
    return when(this) {
        BaseValidationError.InvalidEmptyPasswordLength -> R.string.please_enter_password
        BaseValidationError.InvalidPasswordLength -> R.string.password_should_be_at_least_8_characters_long
        BaseValidationError.InvalidEmptyPhoneNumber -> R.string.please_enter_phone_number
        BaseValidationError.InvalidPhoneNumberLength -> R.string.phone_number_must_be_btweeen_9_and_10_digits
        else -> null
    }
}