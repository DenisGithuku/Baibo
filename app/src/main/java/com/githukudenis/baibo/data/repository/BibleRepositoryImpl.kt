package com.githukudenis.baibo.data.repository

import com.githukudenis.baibo.data.remote.api.BibleApiService
import com.githukudenis.baibo.data.remote.dto.BibleDTO
import com.githukudenis.baibo.data.remote.dto.PassageDTO
import com.githukudenis.baibo.data.remote.dto.VerseDTO
import com.githukudenis.baibo.domain.repository.BibleRepository
import javax.inject.Inject

class BibleRepositoryImpl @Inject constructor(
    private val bibleApiService: BibleApiService,
) : BibleRepository {
    override suspend fun getAllBibles(language: String): List<BibleDTO> {
        return bibleApiService.getAllBibles(language)
    }

    override suspend fun getAllPassagesByBibleAcronym(bible: String): List<PassageDTO> {
        return bibleApiService.getAllPassagesByBibleAcronym(bible)
    }

    override suspend fun getAllVersesByBibleAndPassage(
        bible: String,
        passage: String,
        chapter: String,
    ): List<VerseDTO> {
        return bibleApiService.getAllVersesByBibleAndPassage(bible, passage, chapter)
    }

}
