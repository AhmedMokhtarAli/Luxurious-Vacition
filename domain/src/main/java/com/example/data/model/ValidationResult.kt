package com.example.data.model

data class ValidationResult(
    val isSuccess: Boolean,
    val validationError: ValidationError? = null,
)