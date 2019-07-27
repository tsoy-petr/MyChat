package com.hootor.mychat.data.account

import com.hootor.mychat.domain.account.AccountEntity
import com.hootor.mychat.domain.type.Either
import com.hootor.mychat.domain.type.None
import com.hootor.mychat.domain.type.Failure

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>

    fun logout(): Either<Failure, None>

    fun getCurrentAccount(): Either<Failure, AccountEntity>
    fun saveAccount(accountEntity: AccountEntity): Either<Failure, None>
}