package com.hootor.mychat.ui.account

import android.os.Bundle
import com.hootor.mychat.ui.App
import com.hootor.mychat.ui.core.BaseActivity
import com.hootor.mychat.ui.core.BaseFragment

class AccountActivity : BaseActivity() {
    override var fragment: BaseFragment = AccountFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}
