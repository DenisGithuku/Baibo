package com.githukudenis.baibo.data.remote.dto

import com.githukudenis.baibo.domain.model.Passage

data class PassageDTO(
    val bible: String,
    val bibleTitle: String,
    val languages: List<String>,
    val passages: List<String>
) {
    fun toPassage(): Passage = Passage(bible, bibleTitle, languages, passages)
}
