package com.hootor.mychat.ui.activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hootor.mychat.R
import com.hootor.mychat.cache.AccountCacheImpl
import com.hootor.mychat.cache.SharedPrefsManager
import com.hootor.mychat.data.account.AccountRepositoryImpl
import com.hootor.mychat.domain.account.AccountRepository
import com.hootor.mychat.domain.account.Register
import com.hootor.mychat.remote.account.AccountRemoteImpl
import com.hootor.mychat.remote.core.NetworkHandler
import com.hootor.mychat.remote.core.Request
import com.hootor.mychat.remote.service.ServiceFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)

        val accountCache = AccountCacheImpl(SharedPrefsManager(sharedPrefs))
        val accountRemote = AccountRemoteImpl(Request(NetworkHandler(this)), ServiceFactory.makeService(true))

        val accountRepository: AccountRepository = AccountRepositoryImpl(accountRemote, accountCache)

        accountCache.saveToken("12345")

        val register = Register(accountRepository)
        register(Register.Params("abcde@m.com", "abcde", "123")) {
            it.either({
                Toast.makeText(this, it.javaClass.simpleName, Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_SHORT).show()
            })
        }

    }
}
