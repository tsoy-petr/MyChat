package com.hootor.mychat.presentation.injection

import android.content.Context
import com.hootor.mychat.data.account.AccountCache
import com.hootor.mychat.data.account.AccountRemote
import com.hootor.mychat.data.account.AccountRepositoryImpl
import com.hootor.mychat.domain.account.AccountRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun provideAccountRepository(remote: AccountRemote, cache: AccountCache): AccountRepository {
        return AccountRepositoryImpl(remote, cache)
    }
}