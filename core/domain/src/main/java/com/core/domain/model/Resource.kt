package com.core.domain.model

sealed class Resource <out T> {
    object Loading: Resource<Nothing>()
    object idle: Resource<Nothing>()
    data class Success<out T>(val data: T): Resource<T>()
    data class Error<out T>(val data: T? = null, val message: String?): Resource<T>()
}