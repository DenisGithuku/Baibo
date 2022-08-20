package com.githukudenis.baibo.data.remote.api

import com.githukudenis.baibo.BuildConfig
import com.githukudenis.baibo.common.Constants
import com.githukudenis.baibo.data.remote.dto.BooksDTO
import retrofit2.http.GET
import retrofit2.http.Headers

interface BibleApiService {

    @GET("GetBooks")
    @Headers("X-RapidAPI-Key: ${BuildConfig.API_KEY}", "X-RapidAPI-Host: ${Constants.API_HOST}")
    suspend fun getAllBooks(): BooksDTO
}
