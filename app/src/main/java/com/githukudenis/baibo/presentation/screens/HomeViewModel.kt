package com.githukudenis.baibo.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.githukudenis.baibo.common.NetworkResource
import com.githukudenis.baibo.domain.usecase.BooksUseCases
import com.githukudenis.baibo.presentation.screens.home.HomeUiState
import com.githukudenis.baibo.presentation.screens.home.UserMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val booksUseCases: BooksUseCases
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _uiState

    private var getAllBooksJob: Job? = null
    private val userMessages: MutableList<UserMessage> = mutableListOf()

    init {
        getAllBooks()
    }

    private fun getAllBooks() {
        getAllBooksJob?.cancel()
        getAllBooksJob = booksUseCases.getAllBooks().onEach { result ->
            userMessages.clear()
            when(result) {
                is NetworkResource.Error -> {
                    val userMessage = UserMessage(error = result.error)
                    userMessages.add(userMessage)
                    _uiState.update {
                        it.copy(
                            userMessages = userMessages,
                            isLoadingBooks = false
                        )
                    }
                }
                is NetworkResource.Loading -> {
                    _uiState.update {
                        it.copy(
                            isLoadingBooks = true
                        )
                    }
                }
                is NetworkResource.Success -> {
                    _uiState.update {
                        it.copy(books = result.output)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }


}
