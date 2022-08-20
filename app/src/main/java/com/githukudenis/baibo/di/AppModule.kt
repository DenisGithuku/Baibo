package com.githukudenis.baibo.di

import com.githukudenis.baibo.data.remote.api.BibleApiService
import com.githukudenis.baibo.data.repository.BooksRepositoryImpl
import com.githukudenis.baibo.domain.repository.BooksRepository
import com.githukudenis.baibo.domain.usecase.BooksUseCases
import com.githukudenis.baibo.domain.usecase.GetAllBooks
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    @ViewModelScoped
    fun provideBookUseCases(booksRepository: BooksRepository): BooksUseCases {
        return BooksUseCases(
            getAllBooks = GetAllBooks(booksRepository)
        )
    }

    @Provides
    @ViewModelScoped
    fun provideBooksRepository(bibleApiService: BibleApiService): BooksRepository {
        return BooksRepositoryImpl(bibleApiService = bibleApiService)
    }
}
