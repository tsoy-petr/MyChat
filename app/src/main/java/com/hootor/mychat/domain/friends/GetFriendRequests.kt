package com.hootor.mychat.domain.friends

import com.hootor.mychat.domain.interactor.UseCase
import com.hootor.mychat.domain.type.None
import javax.inject.Inject

class GetFriendRequests @Inject constructor(
    private val friendsRepository: FriendsRepository
) : UseCase<List<FriendEntity>, Boolean>() {

    override suspend fun run(needFetch: Boolean) = friendsRepository.getFriendRequests(needFetch)
}