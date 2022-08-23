package com.githukudenis.baibo.domain.usecase

import com.githukudenis.baibo.common.Language
import com.githukudenis.baibo.common.NetworkResource
import com.githukudenis.baibo.domain.model.BibleData
import com.githukudenis.baibo.domain.model.Books
import com.githukudenis.baibo.domain.repository.BibleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllBibles @Inject constructor(
    private val bibleRepository: BibleRepository,
) {
    operator fun invoke(language: Language): Flow<NetworkResource<List<BibleData>>> = flow {
        try {
            emit(NetworkResource.Loading())
            val lang = when (language) {
                Language.ARABIC -> "ar"
                Language.DUTCH -> "nl"
                Language.ENGLISH -> "en"
                Language.ESPERANTO -> "eo"
                Language.FINISH -> "fi"
                Language.FRENCH -> "fr"
                Language.GREEK -> "el"
            }
            val bibles = bibleRepository.getAllBibles(lang)
            emit(NetworkResource.Success(bibles.map { it.toBibleData() }))
        } catch (t: Throwable) {
            emit(NetworkResource.Error(t))
        }
    }
}
