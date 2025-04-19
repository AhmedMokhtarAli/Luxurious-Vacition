package com.example.data

import com.aait.commondomain.usecase.ValidatePhoneUseCase
import com.example.data.model.BaseValidationError
import org.junit.Assert.assertEquals
import org.junit.Test

class ValidatePhoneNumberUseCaseTest {
    private val validatePhoneNumberUseCase = ValidatePhoneUseCase()
    @Test
    fun `Given 10 digits When invoked Then should success`() {
        val result = validatePhoneNumberUseCase.invoke("0123456789")
        assert(result.isSuccessful)
    }

    @Test
    fun `Given 9 digits When invoked Then should success`() {
        val result = validatePhoneNumberUseCase.invoke("123456789")
        assert(result.isSuccessful)
    }

    @Test
    fun `Given less then 9 digits When invoked Then should fail`() {
        val result = validatePhoneNumberUseCase.invoke("12345678")
        val exception = BaseValidationError.InvalidPhoneNumberLength
        assertEquals(result.validationError,exception)
    }

    @Test
    fun `Given more then 10 digits When invoked Then should fail`() {
        val result = validatePhoneNumberUseCase.invoke("12345678910112")
        val exception = BaseValidationError.InvalidPhoneNumberLength
        assertEquals(result.validationError,exception)
    }


    @Test
    fun `Given empty phone number When invoked Then should fail`() {
        val result = validatePhoneNumberUseCase.invoke("")
        val exception = BaseValidationError.InvalidEmptyPhoneNumber
        assertEquals(result.validationError,exception)
    }
}