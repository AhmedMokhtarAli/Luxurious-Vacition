package com.example.data

import com.example.data.model.SignupValidationError
import com.example.data.usecase.ValidateEmailUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class ValidateEmailUseCaseTest {
    private val validateEmailUseCase = ValidateEmailUseCase()

    @Test
    fun `Given valid email When invoked Then should success`() {
        val result = validateEmailUseCase.invoke("john.c.calhoun@examplepetstore.com")
        assert(result.isSuccessful)
    }

    @Test
    fun `Given empty email When invoked Then should fail`() {
        val result = validateEmailUseCase.invoke("")
        val exception = SignupValidationError.InvalidEmptyEmail
        assertEquals(result.validationError,exception)
    }

    @Test
    fun `Given invalid email When invoked Then should fail`() {
        val result = validateEmailUseCase.invoke("gasdgdsa@fasfd")
        val exception = SignupValidationError.InvalidEmailPattern
        assertEquals(result.validationError,exception)

    }


}