package com.aait.commondomain.usecase

import com.example.data.model.BaseValidationError
import com.example.data.model.ValidationResult
import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor() {

    operator fun invoke(password: String): ValidationResult {
        return when {
            password.isBlank() -> ValidationResult(
                isSuccessful = false,
                BaseValidationError.InvalidEmptyPasswordLength
            )
            password.length < 8 -> ValidationResult(
                isSuccessful = false,
                BaseValidationError.InvalidPasswordLength
            )
            else -> ValidationResult(
                isSuccessful = true,
                null
            )
        }
    }
}