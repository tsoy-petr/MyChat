package com.hootor.mychat.domain.account

import com.hootor.mychat.domain.interactor.UseCase
import com.hootor.mychat.domain.type.None
import javax.inject.Inject

class UpdateToken @Inject constructor(private val accountRepository: AccountRepository) : UseCase<None, UpdateToken.Params>() {

    override suspend fun run(params: Params) = accountRepository.updateAccountToken(params.token)

    data class Params(val token: String)
}