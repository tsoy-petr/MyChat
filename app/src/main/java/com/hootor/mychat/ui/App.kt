package com.hootor.mychat.ui

import android.app.Application
import com.hootor.mychat.presentation.injection.AppModule
import com.hootor.mychat.presentation.injection.CacheModule
import com.hootor.mychat.presentation.injection.RemoteModule
import com.hootor.mychat.presentation.injection.ViewModelModule
import com.hootor.mychat.ui.account.AccountActivity
import com.hootor.mychat.ui.account.AccountFragment
import com.hootor.mychat.ui.core.navigation.RouteActivity
import com.hootor.mychat.ui.register.RegisterActivity
import com.hootor.mychat.ui.register.RegisterFragment
import com.hootor.mychat.ui.firebase.FirebaseService
import com.hootor.mychat.ui.friends.FriendRequestsFragment
import com.hootor.mychat.ui.friends.FriendsFragment
import com.hootor.mychat.ui.home.ChatsFragment
import com.hootor.mychat.ui.home.HomeActivity
import com.hootor.mychat.ui.login.LoginFragment
import dagger.Component
import javax.inject.Singleton

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {

    //activities
    fun inject(activity: RegisterActivity)
    fun inject(activity: RouteActivity)
    fun inject(activity: HomeActivity)
    fun inject(activity: AccountActivity)

    //fragments
    fun inject(fragment: RegisterFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: ChatsFragment)
    fun inject(fragment: FriendsFragment)
    fun inject(fragment: FriendRequestsFragment)
    fun inject(fragment: AccountFragment)

    //services
    fun inject(service: FirebaseService)
}