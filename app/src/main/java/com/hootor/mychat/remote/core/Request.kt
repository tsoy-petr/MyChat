package com.hootor.mychat.remote.core

import com.hootor.mychat.domain.type.Either
import com.hootor.mychat.domain.type.exception.Failure
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Request @Inject constructor(private val networkHandler: NetworkHandler) {

    fun <T : BaseResponse, R> make(call: Call<T>, transform: (T) -> R): Either<Failure, R> {
        return when (networkHandler.isConnected) {
            true -> execute(call, transform)
            false, null -> Either.Left(Failure.NetworkConnectionError)
        }
    }

    private fun <T : BaseResponse, R> execute(call: Call<T>, transform: (T) -> R): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSucceed()) {
                true -> Either.Right(transform((response.body()!!)))
                false -> Either.Left(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }
}

fun <T : BaseResponse> Response<T>.isSucceed(): Boolean {
    return isSuccessful && body() != null && (body() as BaseResponse).success == 1
}

fun <T: BaseResponse> Response<T>.parsError(): Failure {
    val message = (body() as BaseResponse).message
    return when (message) {
        "email already exists" -> Failure.EmailAlreadyExistError
        else -> Failure.ServerError
    }
}


