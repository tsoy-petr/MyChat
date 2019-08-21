package com.hootor.mychat.domain.media

import android.net.Uri
import com.hootor.mychat.domain.interactor.UseCase
import com.hootor.mychat.domain.type.None
import javax.inject.Inject

class CreateImageFile @Inject constructor(
    private val mediaRepository: MediaRepository
) : UseCase<Uri, None>() {

    override suspend fun run(params: None) = mediaRepository.createImageFile()
}