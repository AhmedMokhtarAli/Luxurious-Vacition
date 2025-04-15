package com.example.data.model

data class ValidationResult(
    val isSuccessful: Boolean,
    val validationError: BaseValidationError? = null,
)