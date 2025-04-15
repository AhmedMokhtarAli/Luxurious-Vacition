package com.example.data.model

sealed class ValidationError {
    object InvalidEmptyPhoneNumber : ValidationError()
    object InvalidPhoneNumberLength : ValidationError()
    object InvalidPasswordLength : ValidationError()
    object InvalidEmptyPasswordLength : ValidationError()
}