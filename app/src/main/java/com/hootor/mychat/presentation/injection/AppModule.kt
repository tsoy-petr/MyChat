package com.hootor.mychat.presentation.injection

import android.content.Context
import com.hootor.mychat.data.account.AccountCache
import com.hootor.mychat.data.account.AccountRemote
import com.hootor.mychat.data.account.AccountRepositoryImpl
import com.hootor.mychat.data.friends.FriendsRemote
import com.hootor.mychat.data.media.MediaRepositoryImpl
import com.hootor.mychat.domain.account.AccountRepository
import com.hootor.mychat.domain.friends.FriendsRepository
import com.hootor.mychat.domain.media.MediaRepository
import dagger.Module
import dagger.Provides
import info.fandroid.chat.data.friends.FriendsRepositoryImpl
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

    @Provides
    @Singleton
    fun provideFriendsRepository(remote: FriendsRemote, accountCache: AccountCache): FriendsRepository {
        return FriendsRepositoryImpl(accountCache, remote)
    }

    @Provides
    @Singleton
    fun provideMediaRepository(context: Context): MediaRepository {
        return MediaRepositoryImpl(context)
    }

}