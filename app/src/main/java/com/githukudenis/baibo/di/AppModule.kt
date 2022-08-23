package com.githukudenis.baibo.di

import com.githukudenis.baibo.data.remote.api.BibleApiService
import com.githukudenis.baibo.data.repository.BibleRepositoryImpl
import com.githukudenis.baibo.domain.repository.BibleRepository
import com.githukudenis.baibo.domain.usecase.BibleUseCases
import com.githukudenis.baibo.domain.usecase.GetAllBibles
import com.githukudenis.baibo.domain.usecase.GetAllVersesByBibleAndPassage
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
    fun provideBookUseCases(bibleRepository: BibleRepository): BibleUseCases {
        return BibleUseCases(
            getAllBibles = GetAllBibles(bibleRepository),
            getAllVersesByBibleAndPassage = GetAllVersesByBibleAndPassage(bibleRepository)
        )
    }

    @Provides
    @ViewModelScoped
    fun provideBooksRepository(bibleApiService: BibleApiService): BibleRepository {
        return BibleRepositoryImpl(bibleApiService = bibleApiService)
    }
}
