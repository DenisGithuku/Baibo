package com.githukudenis.baibo.data.repository

import com.githukudenis.baibo.data.remote.dto.BooksDTO
import com.githukudenis.baibo.data.remote.api.BibleApiService
import com.githukudenis.baibo.domain.repository.BooksRepository
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor(
    private val bibleApiService: BibleApiService,
) : BooksRepository {
    override suspend fun getAllBooks(): BooksDTO {
        return bibleApiService.getAllBooks()
    }
}
