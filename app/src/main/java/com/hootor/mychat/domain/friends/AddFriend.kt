package com.hootor.mychat.domain.friends

import com.hootor.mychat.domain.interactor.UseCase
import com.hootor.mychat.domain.type.None
import javax.inject.Inject

class AddFriend @Inject constructor(
    private val friendsRepository: FriendsRepository
) : UseCase<None, AddFriend.Params>() {

    override suspend fun run(params: Params) = friendsRepository.addFriend(params.email)

    data class Params(val email: String)
}