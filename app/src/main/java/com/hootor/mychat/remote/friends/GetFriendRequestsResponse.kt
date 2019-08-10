package com.hootor.mychat.remote.friends

import com.google.gson.annotations.SerializedName
import com.hootor.mychat.domain.friends.FriendEntity
import com.hootor.mychat.remote.core.BaseResponse


class GetFriendRequestsResponse (
    success: Int,
    message: String,
    @SerializedName("friend_requests")
    val friendsRequests: List<FriendEntity>
) : BaseResponse(success, message)