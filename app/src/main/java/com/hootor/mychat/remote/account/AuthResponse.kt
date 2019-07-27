package com.hootor.mychat.remote.account

import com.hootor.mychat.domain.account.AccountEntity
import com.hootor.mychat.remote.core.BaseResponse

class AuthResponse(
    success: Int,
    message: String,
    val user: AccountEntity
) : BaseResponse(success, message)