package com.githukudenis.baibo.data.remote.dto

import com.githukudenis.baibo.domain.model.Verse

data class VerseDTO(
    val number: Int,
    val text: String
) {
    fun toVerse(): Verse = Verse(
        number, text
    )
}
