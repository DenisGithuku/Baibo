package com.githukudenis.baibo.domain.repository

import com.githukudenis.baibo.data.remote.dto.BibleDTO
import com.githukudenis.baibo.data.remote.dto.PassageDTO
import com.githukudenis.baibo.data.remote.dto.VerseDTO

interface BibleRepository {
    suspend fun getAllBibles(language: String): List<BibleDTO>

    suspend fun getAllPassagesByBibleAcronym(bible: String): List<PassageDTO>

    suspend fun getAllVersesByBibleAndPassage(
        bible: String,
        passage: String,
        chapter: String
    ): List<VerseDTO>
}
