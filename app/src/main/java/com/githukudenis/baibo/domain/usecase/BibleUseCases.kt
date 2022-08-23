package com.githukudenis.baibo.domain.usecase

data class BibleUseCases(
    val getAllBibles: GetAllBibles,
    val getAllVersesByBibleAndPassage: GetAllVersesByBibleAndPassage
)
