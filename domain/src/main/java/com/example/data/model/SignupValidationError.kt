package com.example.data.model

sealed class SignupValidationError : BaseValidationError() {
    object InvalidEmptyEmail : SignupValidationError()
    object InvalidEmailPattern : SignupValidationError()
    object InvalidEmptyCity : SignupValidationError()
    object InvalidCityLength : SignupValidationError()
    object InvalidTerms : SignupValidationError()
}