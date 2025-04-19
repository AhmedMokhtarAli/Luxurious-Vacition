package com.example.data

import com.example.data.model.SignupValidationError
import com.example.data.usecase.ValidateCityUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class ValidateCityUseCaseTest {
    val validateCityUseCase = ValidateCityUseCase()
    @Test
    fun `Given equal or more then 3 characters When invoked Then should success`() {
        val result = validateCityUseCase.invoke("aga")
        assert(result.isSuccessful)
    }


    @Test
    fun `Given less then 3 characters When invoked Then should fail`() {
        val result = validateCityUseCase.invoke("ag")
        val exception = SignupValidationError.InvalidCityLength
        assertEquals(result.validationError,exception)
    }

    @Test
    fun `Given empty city When invoked Then should fail`() {
        val result = validateCityUseCase.invoke("")
        val exception = SignupValidationError.InvalidEmptyCity
        assertEquals(result.validationError,exception)
    }
}