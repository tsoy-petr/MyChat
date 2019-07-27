package com.hootor.mychat.data.account

import com.hootor.mychat.domain.account.AccountEntity
import com.hootor.mychat.domain.account.AccountRepository
import com.hootor.mychat.domain.type.*
import java.util.*

class AccountRepositoryImpl(
    private val accountRemote: AccountRemote,
    private val accountCache: AccountCache
) : AccountRepository {

    override fun login(email: String, password: String): Either<Failure, AccountEntity> {
//        throw UnsupportedOperationException("Login is not supported")

        return accountCache.getToken().flatMap {
            accountRemote.login(email, password, it)
        }.onNext {
            accountCache.saveAccount(it)
        }
    }

    override fun logout(): Either<Failure, None> {
//        throw UnsupportedOperationException("Logout is not supported")

        return accountCache.logout()
    }

    override fun register(email: String, name: String, password: String): Either<Failure, None> {
        return accountCache.getToken().flatMap {
            accountRemote.register(email, name, password, it, Calendar.getInstance().timeInMillis)
        }
    }

    override fun forgetPassword(email: String): Either<Failure, None> {
        throw UnsupportedOperationException("Password recovery is not supported")
    }


    override fun getCurrentAccount(): Either<Failure, AccountEntity> {
//        throw UnsupportedOperationException("Get account is not supported")

        return accountCache.getCurrentAccount()
    }


    override fun updateAccountToken(token: String): Either<Failure, None> {
        accountCache.saveToken(token)

        return accountCache.getCurrentAccount().flatMap { accountRemote.updateToken(it.id, token, it.token) }
    }

    override fun updateAccountLastSeen(): Either<Failure, None> {
        throw UnsupportedOperationException("Updating last seen is not supported")
    }


    override fun editAccount(entity: AccountEntity): Either<Failure, AccountEntity> {
        throw UnsupportedOperationException("Editing account is not supported")
    }
}