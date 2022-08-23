package com.githukudenis.baibo.presentation.screens.home

import com.githukudenis.baibo.common.Language
import com.githukudenis.baibo.domain.model.BibleData
import com.githukudenis.baibo.domain.model.Passage
import com.githukudenis.baibo.domain.model.Verse

data class HomeUiState(
    val isLoadingBibles: Boolean = false,
    val bibles: List<BibleData> = emptyList(),
    val verses: List<Verse> = emptyList(),
    val passages: List<Passage> = emptyList(),
    val selectedLanguage: Language = Language.ENGLISH,
    val selectedBibles: MutableList<BibleData> = mutableListOf(),
    val userMessages: MutableList<UserMessage> = mutableListOf(),
) {

    fun addToSelectedBibles(bibleData: BibleData) = selectedBibles.add(bibleData)

    fun removeFromSelectedBibles(bibleData: BibleData) = selectedBibles.remove(bibleData)
    fun addToUserMessages(userMessage: UserMessage) = userMessages.add(userMessage)

    fun clearUserMessages() = userMessages.clear()
}

data class UserMessage(
    val error: Throwable? = null,
    val cause: String? = null,
)
