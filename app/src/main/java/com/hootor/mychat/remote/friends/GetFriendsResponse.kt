package com.hootor.mychat.remote.friends

import com.hootor.mychat.domain.friends.FriendEntity
import com.hootor.mychat.remote.core.BaseResponse


class GetFriendsResponse (
    success: Int,
    message: String,
    val friends: List<FriendEntity>
) : BaseResponse(success, message)