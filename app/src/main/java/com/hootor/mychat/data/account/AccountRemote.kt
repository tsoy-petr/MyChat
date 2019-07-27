package com.hootor.mychat.data.account

import com.hootor.mychat.domain.account.AccountEntity
import com.hootor.mychat.domain.type.Either
import com.hootor.mychat.domain.type.None
import com.hootor.mychat.domain.type.Failure

interface AccountRemote {
    fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None>

    fun login(email: String, password: String, token: String): Either<Failure, AccountEntity>

    fun updateToken(userId: Long, token: String, oldToken: String): Either<Failure, None>
}