package com.hootor.mychat.cache

import com.hootor.mychat.data.account.AccountCache
import com.hootor.mychat.domain.account.AccountEntity
import com.hootor.mychat.domain.type.Either
import com.hootor.mychat.domain.type.None
import com.hootor.mychat.domain.type.Failure
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager) : AccountCache {

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token)
    }

    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken()
    }

    override fun logout(): Either<Failure, None> {
        return prefsManager.removeAccount()
    }

    override fun getCurrentAccount(): Either<Failure, AccountEntity> {
        return prefsManager.getAccount()
    }

    override fun saveAccount(account: AccountEntity): Either<Failure, None> {
        return prefsManager.saveAccount(account)
    }

}