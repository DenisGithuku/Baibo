package com.githukudenis.baibo.domain.usecase

import com.githukudenis.baibo.common.NetworkResource
import com.githukudenis.baibo.data.remote.dto.toBooks
import com.githukudenis.baibo.domain.model.Books
import com.githukudenis.baibo.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllBooks @Inject constructor(
    private val booksRepository: BooksRepository
) {
    operator fun invoke(): Flow<NetworkResource<Books>> = flow {
        try {
            emit(NetworkResource.Loading())
            val books = booksRepository.getAllBooks()
            emit(NetworkResource.Success(books.toBooks()))
        } catch (t: Throwable) {
            emit(NetworkResource.Error(t))
        }
    }
}
