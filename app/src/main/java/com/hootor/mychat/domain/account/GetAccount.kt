package com.hootor.mychat.domain.account

import com.hootor.mychat.domain.interactor.UseCase
import com.hootor.mychat.domain.type.Either
import com.hootor.mychat.domain.type.Failure
import com.hootor.mychat.domain.type.None
import javax.inject.Inject

class GetAccount @Inject constructor(
    private val accountRepository: AccountRepository
): UseCase<AccountEntity, None>() {

    override suspend fun run(params: None): Either<Failure, AccountEntity> {
        return accountRepository.getCurrentAccount()
    }

}