package com.glengarry.network.utils

import com.common.reduceFileImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

suspend fun File.toMultipartBody(name: String): MultipartBody.Part {
    val compressedPhoto = withContext(Dispatchers.Default) {
        async { reduceFileImage() }.await()
    }
    val photoRequestBody = compressedPhoto.asRequestBody("image/jpeg".toMediaType())
    return MultipartBody.Part.createFormData(
        name = name,
        filename = compressedPhoto.name,
        body = photoRequestBody
    )
}
