package com.aait.commondomain.usecase

import com.example.data.model.ValidationError
import com.example.data.model.ValidationResult
import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor() {

    operator fun invoke(password: String): ValidationResult {
        return when {
            password.isBlank() -> ValidationResult(
                isSuccess = false,
                ValidationError.InvalidEmptyPasswordLength
            )
            password.length < 8 -> ValidationResult(
                isSuccess = false,
                ValidationError.InvalidPasswordLength
            )
            else -> ValidationResult(
                isSuccess = true,
                null
            )
        }
    }
}