package com.hootor.mychat.data.friends

import com.hootor.mychat.domain.friends.FriendEntity

interface FriendsCache {

    fun saveFriend(entity: FriendEntity)

    fun getFriend(key: Long): FriendEntity?

    fun getFriends(): List<FriendEntity>

    fun getFriendRequests(): List<FriendEntity>

    fun removeFriendEntity(key: Long)
}