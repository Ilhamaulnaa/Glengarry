package com.data.user.domain.interactor

import com.core.domain.model.Resource
import com.data.user.domain.model.LoginResult
import com.data.user.domain.model.RefreshTokenResult
import com.data.user.domain.model.RegisterResult
import com.data.user.domain.model.UpdateProfileImageResult
import com.data.user.domain.model.User
import com.data.user.domain.repository.UserRepository
import com.data.user.domain.usecase.UserUseCase
import kotlinx.coroutines.flow.Flow
import java.io.File

class UserInteractor(
    private val repository: UserRepository
) : UserUseCase {

    override fun login(email: String, password: String): Flow<Resource<LoginResult>> {
        return repository.login(email, password)
    }

    override fun register(email: String, password: String): Flow<Resource<RegisterResult>> {
        return repository.register(email, password)
    }

    override fun getUserLogging(authorization: String): Flow<Resource<User>> {
        return repository.getUserLogging(authorization)
    }

    override fun updateUser(
        authorization: String,
        name: String,
        email: String,
        birthDate: String,
        phoneNumber: String,
        domicile: String
    ): Flow<Resource<User>> {
        return repository.updateUser(authorization, name, email, birthDate, phoneNumber, domicile)
    }

    override fun refreshToken(refreshToken: String): Flow<Resource<RefreshTokenResult>> {
        return repository.refreshToken(refreshToken)
    }

    override suspend fun updatePhotoProfile(
        authorization: String,
        name: String
    ): Flow<Resource<String>> {
        return repository.updatePhotoProfile(authorization, name)
    }

    override suspend fun updateProfileImage(
        authorization: String,
        image: File
    ): Flow<Resource<UpdateProfileImageResult>> {
        return repository.updateProfileImage(
            authorization = authorization,
            image = image
        )
    }
}