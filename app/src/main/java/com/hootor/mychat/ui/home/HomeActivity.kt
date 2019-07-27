package com.hootor.mychat.ui.home

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.hootor.mychat.R
import com.hootor.mychat.domain.account.AccountEntity
import com.hootor.mychat.domain.type.None
import com.hootor.mychat.presentation.viewmodel.AccountViewModel
import com.hootor.mychat.ui.App
import com.hootor.mychat.ui.core.BaseActivity
import com.hootor.mychat.ui.core.ext.onFailure
import com.hootor.mychat.ui.core.ext.onSuccess
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.navigation.*


class HomeActivity : BaseActivity() {

    override val fragment = ChatsFragment()

    override val contentId = R.layout.activity_navigation

    private lateinit var accountViewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.appComponent.inject(this)

        accountViewModel = viewModel {
            onSuccess(accountData, ::handleAccount)
            onSuccess(logoutData, ::handleLogout)
            onFailure(failureData, ::handleFailure)
        }

        accountViewModel.getAccount()

        supportActionBar?.setHomeAsUpIndicator(R.drawable.menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnLogout.setOnClickListener {
            accountViewModel.logout()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawer(navigationView)
                } else {
                    drawerLayout.openDrawer(navigationView)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun handleAccount(accountEntity: AccountEntity?) {
        accountEntity?.let {
            tvUserName.text = it.name
            tvUserEmail.text = it.email
            tvUserStatus.text = it.status

            tvUserStatus.visibility = if (it.status.isNotEmpty()) View.VISIBLE else View.GONE
        }
    }

    private fun handleLogout(none: None?) {
        navigator.showLogin(this)
        finish()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView)
        } else {
            super.onBackPressed()
        }
    }
}