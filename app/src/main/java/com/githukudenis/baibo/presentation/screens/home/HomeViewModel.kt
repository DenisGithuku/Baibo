package com.githukudenis.baibo.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.githukudenis.baibo.common.NetworkResource
import com.githukudenis.baibo.domain.usecase.BibleUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bibleUseCases: BibleUseCases
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _uiState

    private var getAllBooksJob: Job? = null
    private var getAllVersesJob: Job? = null
    init {
        getAllBooks()
    }

    private fun getAllBooks() {
        getAllBooksJob?.cancel()
        getAllBooksJob = bibleUseCases.getAllBibles(_uiState.value.selectedLanguage).onEach { result ->
            _uiState.value.clearUserMessages()
            when(result) {
                is NetworkResource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoadingBibles = false
                        )
                    }
                    val userMessage = UserMessage(error = result.error)
                    _uiState.value.addToUserMessages(userMessage)
                }
                is NetworkResource.Loading -> {
                    _uiState.update {
                        it.copy(
                            isLoadingBibles = true
                        )
                    }
                }
                is NetworkResource.Success -> {
                    _uiState.update {
                        it.copy(bibles = result.output ?: emptyList())
                    }
                }
            }
        }.launchIn(viewModelScope)
    }


    fun onEvent(homeEvent: HomeEvent) {
        when(homeEvent) {
            is HomeEvent.AddToSelectedBibles -> {
               _uiState.value.addToSelectedBibles(homeEvent.bibleData)
            }
            HomeEvent.DownloadSelectedBibles -> {
                if (_uiState.value.selectedBibles.isEmpty()) {
                    _uiState.value.addToUserMessages(UserMessage(error = Throwable(message = "At least one bibles must be selected")))
                    return
                }

                _uiState.value.selectedBibles.forEach { bible ->

                }
            }
            is HomeEvent.RemoveFromSelectedBibles -> {
                _uiState.value.removeFromSelectedBibles(homeEvent.bibleData)
            }
        }
    }

    fun getAllVerses(
        bible: String,
        passage: String,
        chapter: String
    ) {
        getAllVersesJob?.cancel()
        getAllBooksJob = bibleUseCases.getAllVersesByBibleAndPassage(bible, passage, chapter).onEach { result ->
            _uiState.value.clearUserMessages()
            when(result) {
                is NetworkResource.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoadingBibles = false
                        )
                    }
                    val userMessage = UserMessage(error = result.error)
                    _uiState.value.addToUserMessages(userMessage)
                }
                is NetworkResource.Loading -> {
                    _uiState.update {
                        it.copy(
                            isLoadingBibles = true
                        )
                    }
                }
                is NetworkResource.Success -> {
                    _uiState.update {
                        it.copy(
                            verses = result.output ?: emptyList()
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }


}
