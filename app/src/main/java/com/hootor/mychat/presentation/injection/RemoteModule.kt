package com.hootor.mychat.presentation.injection

import com.hootor.mychat.BuildConfig
import com.hootor.mychat.data.account.AccountRemote
import com.hootor.mychat.remote.account.AccountRemoteImpl
import com.hootor.mychat.remote.core.Request
import com.hootor.mychat.remote.service.ApiService
import com.hootor.mychat.remote.service.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)
    }
}