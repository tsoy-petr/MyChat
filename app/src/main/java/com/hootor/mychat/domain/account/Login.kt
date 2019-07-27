package com.hootor.mychat.domain.account

import com.hootor.mychat.domain.interactor.UseCase
import com.hootor.mychat.domain.type.Either
import com.hootor.mychat.domain.type.Failure
import javax.inject.Inject

class Login @Inject constructor(
    private val accountRepository: AccountRepository
): UseCase<AccountEntity, Login.Params>(){


    override suspend fun run(params: Params): Either<Failure, AccountEntity> {

    return accountRepository.login(params.email, params.password)

    }

    data class Params(val email: String, val password: String)

}