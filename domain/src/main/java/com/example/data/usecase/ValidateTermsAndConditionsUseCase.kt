package com.example.data.usecase

import com.example.data.model.SignupValidationError
import com.example.data.model.ValidationResult
import javax.inject.Inject

class ValidateTermsAndConditionsUseCase @Inject constructor() {
    operator fun invoke(isAccepted: Boolean): ValidationResult {
        return if (!isAccepted) {
            ValidationResult(
                isSuccessful = false,
                validationError = SignupValidationError.InvalidTerms
            )
        } else {
            ValidationResult(isSuccessful = true, validationError = null)
        }
    }
}