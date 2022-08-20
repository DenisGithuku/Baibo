package com.githukudenis.baibo.common

sealed class NetworkResource<out T>(val output: T? = null, val error: Throwable? = null) {
    class Loading<T>: NetworkResource<T>()
    class Success<T>(private val data: T): NetworkResource<T>(output = data)
    class Error<T>(val exception: Throwable): NetworkResource<T>(error = exception)
}
