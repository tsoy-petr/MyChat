package com.hootor.mychat.domain.media

import android.graphics.Bitmap
import com.hootor.mychat.domain.interactor.UseCase
import javax.inject.Inject

class EncodeImageBitmap @Inject constructor(
    private val mediaRepository: MediaRepository
) : UseCase<String, Bitmap?>() {

    override suspend fun run(params: Bitmap?) = mediaRepository.encodeImageBitmap(params)
}