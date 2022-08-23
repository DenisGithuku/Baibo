package com.githukudenis.baibo.data.remote.api

import com.githukudenis.baibo.BuildConfig
import com.githukudenis.baibo.common.Constants
import com.githukudenis.baibo.data.remote.dto.BibleDTO
import com.githukudenis.baibo.data.remote.dto.PassageDTO
import com.githukudenis.baibo.data.remote.dto.VerseDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface BibleApiService {

    @GET("bibles")
    @Headers("X-RapidAPI-Key: ${BuildConfig.API_KEY}", "X-RapidAPI-Host: ${Constants.API_HOST}")
    suspend fun getAllBibles(@Query("lang") language: String): List<BibleDTO>

    @GET("passages")
    @Headers("X-RapidAPI-Key: ${BuildConfig.API_KEY}", "X-RapidAPI-Host: ${Constants.API_HOST}")
    suspend fun getAllPassagesByBibleAcronym(
        @Path("bible") bible: String
    ): List<PassageDTO>

    @GET("verses/")
    @Headers("X-RapidAPI-Key: ${BuildConfig.API_KEY}", "X-RapidAPI-Host: ${Constants.API_HOST}")
    suspend fun getAllVersesByBibleAndPassage(
        @Path(" bible") bible: String,
        @Path(" passage") passage: String,
        @Path(" chapter") chapter: String,
    ): List<VerseDTO>
}
