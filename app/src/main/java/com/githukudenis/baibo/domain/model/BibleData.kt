package com.githukudenis.baibo.domain.model

data class BibleData(
    val abbreviatedTitle: String,
    val bible: String,
    val copyright: String,
    val description: String,
    val extendedCopyright: String,
    val imageUrl: String,
    val languages: List<String>,
    val publicationDate: String,
    val publishers: List<String>,
    val title: String
)
