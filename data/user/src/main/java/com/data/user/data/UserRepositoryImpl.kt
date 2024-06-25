package com.data.user.data

import com.common.reduceFileImage
import com.core.domain.model.Resource
import com.data.user.data.mapper.toDomain
import com.data.user.data.remote.service.UserService
import com.data.user.domain.model.LoginResult
import com.data.user.domain.model.RefreshTokenResult
import com.data.user.domain.model.RegisterResult
import com.data.user.domain.model.UpdateProfileImageResult
import com.data.user.domain.model.User
import com.data.user.domain.repository.UserRepository
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class UserRepositoryImpl(
    private val service: UserService
) : UserRepository {

    override fun login(email: String, password: String): Flow<Resource<LoginResult>> = flow {
        emit(Resource.Loading)
        when (val response = service.login(email, password)){
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null){
                    emit(Resource.Error(message = "Data Null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }


    override fun register(email: String, password: String): Flow<Resource<RegisterResult>> = flow {
        emit(Resource.Loading)
        when (val response = service.register(email, password)){
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null) {
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }

    override fun getUserLogging(authorization: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading)
        val authToken = "Bearer $authorization"
        when (val response = service.getUserLogging(authToken)) {
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null) {
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }


    override fun updateUser(
        authorization: String,
        name: String,
        email: String,
        birthDate: String,
        phoneNumber: String,
        domicile: String
    ): Flow<Resource<User>> = flow {
        emit(Resource.Loading)
        val authToken = "Bearer $authorization"
        val response = service.updateUser(
            authToken,
            name,
            email,
            birthDate,
            phoneNumber,
            domicile
        )
        when (response) {
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null) {
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }


    override fun refreshToken(refreshToken: String): Flow<Resource<RefreshTokenResult>> = flow{
        emit(Resource.Loading)
        when (val response = service.refreshToken(refreshToken)) {
            is NetworkResponse.Success -> {
                val result = response.body.data?.toDomain()
                if (result == null) {
                    emit(Resource.Error(message = "Data null"))
                    return@flow
                }
                emit(Resource.Success(result))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }

    override suspend fun updatePhotoProfile(
        authorization: String,
        name: String
    ): Flow<Resource<String>> = flow {
        emit(Resource.Loading)
        val authToken = "Bearer $authorization"
        when (val response = service.updatePhotoProfile(authToken, name)) {
            is NetworkResponse.Success -> {
                emit(Resource.Success(data = "Image profile updated!"))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }

    override suspend fun updateProfileImage(
        authorization: String,
        image: File
    ): Flow<Resource<UpdateProfileImageResult>> = flow<Resource<UpdateProfileImageResult>> {
        emit(Resource.Loading)
        val authToken = "Barier $authorization"
        val compressedImage = withContext(Dispatchers.Default){
            async { image.reduceFileImage() }.await()
        }
        val imageRequestBody = compressedImage.asRequestBody("image/jpg".toMediaType())
        val imageMultipart = MultipartBody.Part.createFormData(
            "profile_img",
            image.name,
            imageRequestBody
        )
        when (val response = service.updateProfileImage(authToken, imageMultipart)) {
            is NetworkResponse.Success -> {
                emit(Resource.Success(data = response.body.toDomain()))
            }
            is NetworkResponse.Error -> {
                val message = response.body?.message ?: response.error?.message
                emit(Resource.Error(message = message))
            }
        }
    }.catch {
        emit(Resource.Error(message = it.message))
    }
}