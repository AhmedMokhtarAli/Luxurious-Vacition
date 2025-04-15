package com.aait.commondomain.usecase

import com.example.data.model.BaseValidationError
import com.example.data.model.ValidationResult
import javax.inject.Inject

class ValidatePhoneUseCase @Inject constructor() {
    operator fun invoke(phone: String): ValidationResult {
        return when {
            phone.isBlank() -> ValidationResult(
                isSuccessful = false,
                validationError = BaseValidationError.InvalidEmptyPhoneNumber
            )
            phone.length !in 9..10 -> ValidationResult(
                isSuccessful = false,
                validationError = BaseValidationError.InvalidPhoneNumberLength)
            else -> ValidationResult(true, null)
        }
    }


}