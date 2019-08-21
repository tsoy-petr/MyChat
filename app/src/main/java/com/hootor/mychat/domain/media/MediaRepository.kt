package com.hootor.mychat.domain.media

import android.graphics.Bitmap
import android.net.Uri
import com.hootor.mychat.domain.type.Either
import com.hootor.mychat.domain.type.Failure

interface MediaRepository {

    fun createImageFile(): Either<Failure, Uri>
    fun encodeImageBitmap(bitmap: Bitmap?): Either<Failure, String>
    fun getPickedImage(uri: Uri?): Either<Failure, Bitmap>

}