package com.githukudenis.baibo.domain.usecase

import com.githukudenis.baibo.common.NetworkResource
import com.githukudenis.baibo.domain.model.BibleData
import com.githukudenis.baibo.domain.model.Verse
import com.githukudenis.baibo.domain.repository.BibleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllVersesByBibleAndPassage @Inject constructor(
    private val bibleRepository: BibleRepository
) {
    operator fun invoke(
        bible: String,
        passage: String,
        chapter: String
    ): Flow<NetworkResource<List<Verse>>> = flow {
        try {
            emit(NetworkResource.Loading())
            val verses = bibleRepository.getAllVersesByBibleAndPassage(bible, passage, chapter).map {verseDTO ->
                verseDTO.toVerse()
            }
            emit(NetworkResource.Success(verses))
        } catch (t: Throwable) {
            emit(NetworkResource.Error(exception = t))
        }
    }.flowOn(Dispatchers.IO)
}
