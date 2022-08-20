package com.githukudenis.baibo.presentation.screens.home

import com.githukudenis.baibo.domain.model.Books

data class HomeUiState(
    val isLoadingBooks: Boolean = false,
    val books: Books? = null,
    val userMessages: List<UserMessage> = emptyList()
)

data class UserMessage(
    val error: Throwable? = null,
    val cause: String? = null
)
