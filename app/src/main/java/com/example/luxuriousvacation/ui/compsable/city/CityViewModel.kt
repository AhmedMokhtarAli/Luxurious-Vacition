package com.example.luxuriousvacation.ui.compsable.city

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) :
    ViewModel() {
    private val _cityName = MutableStateFlow("")
    val cityName = _cityName.asStateFlow()

    private val args: String = checkNotNull( savedStateHandle["name"])

    init {
        setName()
    }
    private fun setName(){
        _cityName.update { args }
    }
}