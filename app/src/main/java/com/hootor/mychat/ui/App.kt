package com.hootor.mychat.ui

import android.app.Application
import com.hootor.mychat.presentation.injection.AppModule
import com.hootor.mychat.presentation.injection.CacheModule
import com.hootor.mychat.presentation.injection.RemoteModule
import com.hootor.mychat.presentation.injection.ViewModelModule
import com.hootor.mychat.ui.activity.RegisterActivity
import com.hootor.mychat.ui.fragment.RegisterFragment
import com.hootor.mychat.ui.service.FirebaseService
import dagger.Component
import javax.inject.Singleton

class App: Application() {

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

    //fragments
    fun inject(fragment: RegisterFragment)

    //services
    fun inject(service: FirebaseService)

}