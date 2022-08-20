package com.githukudenis.baibo.domain.repository

import com.githukudenis.baibo.data.remote.dto.BooksDTO

interface BooksRepository {
    suspend fun getAllBooks(): BooksDTO
}
