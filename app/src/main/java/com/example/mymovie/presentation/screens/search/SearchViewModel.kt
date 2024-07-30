package com.example.mymovie.presentation.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovie.domain.model.Movie
import com.example.mymovie.domain.usecase.SearchMovieUseCase
import com.example.mymovie.presentation.base.DataState
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicBoolean

class SearchViewModel(private val searchMovieUseCase: SearchMovieUseCase) : ViewModel() {
    private val _inputText: MutableStateFlow<String> =
        MutableStateFlow("")
    val inputText: StateFlow<String> = _inputText

    private val _resultState: MutableStateFlow<DataState<List<Movie>>> =
        MutableStateFlow(DataState.Success(emptyList()))
    val resultState: StateFlow<DataState<List<Movie>>> = _resultState

    private val isInitialized = AtomicBoolean(false)

    @OptIn(FlowPreview::class)
    fun initialize() {
        if (isInitialized.compareAndSet(false, true)) {
            viewModelScope.launch {
                inputText.debounce(500).collectLatest { input ->
                    if (input.isBlank()) {
                        _resultState.value = DataState.Success(emptyList())
                        return@collectLatest
                    }

                    try {
                        _resultState.value = DataState.Loading
                        val result = searchMovieUseCase.execute(input)
                        _resultState.value = DataState.Success(result)
                    } catch (e: Exception) {
                        _resultState.value = DataState.Error(e.message.toString())
                    }
                }
            }
        }
    }

    fun setInputText(text: String) {
        _inputText.value = text
    }
}