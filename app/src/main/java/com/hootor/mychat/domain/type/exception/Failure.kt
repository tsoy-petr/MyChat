package com.hootor.mychat.domain.type.exception


sealed class Failure {
    object NetworkConnectionError : Failure()
    object ServerError : Failure()

    object EmailAlreadyExistError : Failure()
}