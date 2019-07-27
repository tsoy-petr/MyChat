package com.hootor.mychat.domain.account

import com.hootor.mychat.domain.interactor.UseCase
import com.hootor.mychat.domain.type.Either
import com.hootor.mychat.domain.type.None
import com.hootor.mychat.domain.type.Failure
import javax.inject.Inject

class Register @Inject constructor(private val repository: AccountRepository) : UseCase<None, Register.Params>() {

    override suspend fun run(params: Params): Either<Failure, None> {
        return repository.register(params.email, params.name, params.password)
    }

    data class Params(val email: String, val name: String, val password: String)
}