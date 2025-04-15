package com.example.data.usecase

import com.example.data.model.SignupValidationError
import com.example.data.model.ValidationResult
import javax.inject.Inject

class ValidateCityUseCase @Inject constructor() {

    operator fun invoke(cityName: String): ValidationResult {
        if (cityName.length < 3) {
            return ValidationResult(
                isSuccessful = false,
                validationError = SignupValidationError.InvalidCity
            )
        } else {
            return ValidationResult(
                isSuccessful = true,
                validationError = null
            )
        }
    }

}