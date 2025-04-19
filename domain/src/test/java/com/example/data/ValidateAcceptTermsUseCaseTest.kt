package com.example.data

import com.example.data.model.SignupValidationError
import com.example.data.usecase.ValidateAcceptTermsUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class ValidateAcceptTermsUseCaseTest {
    private val validateAcceptTermsUseCase = ValidateAcceptTermsUseCase()
    @Test
    fun `Given accept terms When invoked Then should success`() {
        val result = validateAcceptTermsUseCase.invoke(true)
        assert(result.isSuccessful)
    }


    @Test
    fun `Given refuse terms When invoked Then should fail`() {
        val result = validateAcceptTermsUseCase.invoke(false)
        val exception = SignupValidationError.InvalidTerms
        assertEquals(result.validationError,exception)
    }


}