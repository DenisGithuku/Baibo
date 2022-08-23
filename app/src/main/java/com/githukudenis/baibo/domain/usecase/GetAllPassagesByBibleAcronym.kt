package com.githukudenis.baibo.domain.usecase

import com.githukudenis.baibo.common.NetworkResource
import com.githukudenis.baibo.domain.model.Passage
import com.githukudenis.baibo.domain.repository.BibleRepository
import dagger.multibindings.IntKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllPassagesByBibleAcronym @Inject constructor(
    private val bibleRepository: BibleRepository
) {
    operator fun invoke(bible: String): Flow<NetworkResource<List<Passage>>> = flow {
        try {
            emit(NetworkResource.Loading())
            val passages = bibleRepository.getAllPassagesByBibleAcronym(bible).map { it.toPassage() }
            emit(NetworkResource.Success(passages))
        } catch (t: Throwable) {
            emit(NetworkResource.Error(exception = t))
        }
    }.flowOn(Dispatchers.IO)
}
