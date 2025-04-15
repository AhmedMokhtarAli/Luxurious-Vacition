package com.example.data.model

sealed class BaseValidationError {
    object InvalidEmptyPhoneNumber : BaseValidationError()
    object InvalidPhoneNumberLength : BaseValidationError()
    object InvalidPasswordLength : BaseValidationError()
    object InvalidEmptyPasswordLength : BaseValidationError()
 }