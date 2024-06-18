package com.glengarry.network.utils

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

fun <T>T.toRequestBody(): RequestBody {
    return toString().toRequestBody("text/plain".toMediaType())
}

