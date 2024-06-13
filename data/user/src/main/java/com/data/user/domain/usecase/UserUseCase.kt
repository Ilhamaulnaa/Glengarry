package com.data.user.domain.usecase

import com.core.domain.model.Resource
import com.data.user.domain.model.LoginResult
import com.data.user.domain.model.RefreshTokenResult
import com.data.user.domain.model.RegisterResult
import com.data.user.domain.model.UpdateProfileImageResult
import com.data.user.domain.model.User
import kotlinx.coroutines.flow.Flow
import java.io.File

interface UserUseCase {

    fun login(
        email: String,
        password: String
    ): Flow<Resource<LoginResult>>

    fun register(
        email: String,
        password: String
    ): Flow<Resource<RegisterResult>>

    fun getUserLogging(
        authorization: String
    ): Flow<Resource<User>>

    fun updateUser(
        authorization: String,
        name: String,
        email: String,
        birthDate: String,
        phoneNumber: String,
        domicile: String,
    ): Flow<Resource<User>>

    fun refreshToken(
        refreshToken: String,
    ): Flow<Resource<RefreshTokenResult>>

    suspend fun updatePhotoProfile(
        authorization: String,
        name: String
    ): Flow<Resource<String>>

    suspend fun updateProfileImage(
        authorization: String,
        image: File
    ): Flow<Resource<UpdateProfileImageResult>>
}