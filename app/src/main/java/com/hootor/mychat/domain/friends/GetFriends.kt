package com.hootor.mychat.domain.friends

import com.hootor.mychat.domain.interactor.UseCase
import com.hootor.mychat.domain.type.None
import javax.inject.Inject


class GetFriends @Inject constructor(
    private val friendsRepository: FriendsRepository
) : UseCase<List<FriendEntity>, None>() {

    override suspend fun run(params: None) = friendsRepository.getFriends()
}