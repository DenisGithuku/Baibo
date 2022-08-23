package com.githukudenis.baibo.data.remote.dto

import com.githukudenis.baibo.domain.model.BibleData

data class BibleDTO(
    val abbreviatedTitle: String,
    val bible: String,
    val copyright: String,
    val description: String,
    val extendedCopyright: String,
    val imageUrl: String,
    val languages: List<String>,
    val publicationDate: String,
    val publishers: List<String>,
    val title: String,
) {
    fun toBibleData(): BibleData {
        return BibleData(
            abbreviatedTitle,
            bible,
            copyright,
            description,
            extendedCopyright,
            imageUrl,
            languages,
            publicationDate,
            publishers,
            title
        )
    }
}
