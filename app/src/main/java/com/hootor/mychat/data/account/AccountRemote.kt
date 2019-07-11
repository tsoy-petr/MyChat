package com.hootor.mychat.data.account

import com.hootor.mychat.domain.type.Either
import com.hootor.mychat.domain.type.None
import com.hootor.mychat.domain.type.exception.Failure

interface AccountRemote {
    fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None>
}