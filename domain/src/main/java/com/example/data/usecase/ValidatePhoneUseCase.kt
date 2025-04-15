package com.aait.commondomain.usecase

import com.example.data.model.ValidationError
import com.example.data.model.ValidationResult
import javax.inject.Inject

class ValidatePhoneUseCase @Inject constructor() {
    operator fun invoke(phone: String): ValidationResult {
        return when {
            phone.isBlank() -> ValidationResult(
                isSuccess = false,
                validationError = ValidationError.InvalidEmptyPhoneNumber
            )
            phone.length !in 9..10 -> ValidationResult(
                isSuccess = false,
                validationError = ValidationError.InvalidPhoneNumberLength)
            else -> ValidationResult(true, null)
        }
    }


}