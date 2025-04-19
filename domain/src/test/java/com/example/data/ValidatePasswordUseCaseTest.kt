package com.example.data

import com.aait.commondomain.usecase.ValidatePasswordUseCase
import com.example.data.model.BaseValidationError
import org.junit.Assert.assertEquals
import org.junit.Test

class ValidatePasswordUseCaseTest {
    private val validatePasswordUseCase = ValidatePasswordUseCase()

    @Test
    fun `Given password 8 digits or more When invoked then should pass`() {
        val result = validatePasswordUseCase.invoke("12345678")
        assertEquals(result.isSuccessful, true)
    }


    @Test
    fun `Given password less Then 8 digits When invoked Then should fail`() {
        val result = validatePasswordUseCase.invoke("1234567")
        val exception = BaseValidationError.InvalidPasswordLength
        assertEquals(result.validationError, exception)
    }

    @Test
    fun `Given empty password When invoked Then should fail`() {
        val exception = BaseValidationError.InvalidEmptyPasswordLength
        val result = validatePasswordUseCase.invoke("")
        assertEquals(result.validationError, exception)
    }

}


