package com.example.data.model

sealed class SignupValidationError : BaseValidationError() {
    object InvalidEmptyEmail : SignupValidationError()
    object InvalidEmailPattern : SignupValidationError()
    object InvalidCity : SignupValidationError()
    object InvalidTerms : SignupValidationError()
}