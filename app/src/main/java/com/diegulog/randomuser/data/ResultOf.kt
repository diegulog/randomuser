package com.diegulog.randomuser.data

/**
 * Generic class that contains a value with its loading ..
 * @param <T>
 */
sealed class ResultOf<out T> {
    data class Success<out T>(val value: T) : ResultOf<T>()
    data class Failure(val throwable: Throwable?) : ResultOf<Nothing>()
    object Loading : ResultOf<Nothing>()
}
