package com.example.luxuriousvacation.ui.screens.signup

import com.example.data.model.BaseValidationError
import com.example.data.model.SignupValidationError
import com.example.luxuriousvacation.R
import com.example.luxuriousvacation.ui.utilis.setValidationMessage

fun BaseValidationError?.setSignupValidationMessage(): Int? {
    return when(this) {
        SignupValidationError.InvalidEmptyEmail -> R.string.please_enter_email
        SignupValidationError.InvalidEmailPattern -> R.string.invalid_email_pattern
       SignupValidationError.InvalidEmptyCity -> R.string.please_enter_city
        SignupValidationError.InvalidCityLength -> R.string.too_short_city_name
        SignupValidationError.InvalidTerms -> R.string.please_accept_terms_and_conditions
        else -> this.setValidationMessage()
    }
}