package com.hootor.mychat.data.friends

import com.hootor.mychat.domain.friends.FriendEntity
import com.hootor.mychat.domain.type.Either
import com.hootor.mychat.domain.type.Failure
import com.hootor.mychat.domain.type.None

interface FriendsRemote {
    fun getFriends(userId: Long, token: String): Either<Failure, List<FriendEntity>>
    fun getFriendRequests(userId: Long, token: String): Either<Failure, List<FriendEntity>>

    fun approveFriendRequest(userId: Long, requestUserId: Long, friendsId: Long, token: String): Either<Failure, None>
    fun cancelFriendRequest(userId: Long, requestUserId: Long, friendsId: Long, token: String): Either<Failure, None>

    fun addFriend(email: String, userId: Long, token: String): Either<Failure, None>
    fun deleteFriend(userId: Long, requestUserId: Long, friendsId: Long, token: String): Either<Failure, None>
}