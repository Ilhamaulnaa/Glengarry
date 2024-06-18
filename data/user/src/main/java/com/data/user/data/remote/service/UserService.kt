package com.data.user.data.remote.service

import com.data.user.data.remote.response.LoginResponse
import com.data.user.data.remote.response.RefreshTokenResponse
import com.data.user.data.remote.response.RegisterResponse
import com.data.user.data.remote.response.UpdatePhotoProfileResponse
import com.data.user.data.remote.response.UpdateProfileImageResponse
import com.data.user.data.remote.response.UserResponse
import com.glengarry.network.response.CommonBaseResponse
import com.glengarry.network.response.CommonErrorResponse
import com.haroldadmin.cnradapter.NetworkResponse
import okhttp3.MultipartBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part

interface UserService {

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): NetworkResponse<CommonBaseResponse<LoginResponse>, CommonErrorResponse>

    @FormUrlEncoded
    @POST("user/register")
    suspend fun register(
        @Field("email") email: String,
        @Field("password") password: String
    ): NetworkResponse<CommonBaseResponse<RegisterResponse>, CommonErrorResponse>

    @GET("user/me")
    suspend fun getUserLogging(
        @Header("Authorization") authorization: String
    ): NetworkResponse<CommonBaseResponse<UserResponse>, CommonErrorResponse>

    @FormUrlEncoded
    @PATCH("user/me")
    suspend fun updateUser(
        @Header("Authorization") authorization: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("dob") birthDate: String,
        @Field("phoneNumber") phoneNumber: String,
        @Field("location") location: String,
    ): NetworkResponse<CommonBaseResponse<UserResponse>, CommonErrorResponse>

    @FormUrlEncoded
    @PATCH("user/me/profile-img")
    suspend fun updatePhotoProfile(
        @Header("Authorization") authorization: String,
        @Field("profile_img") name: String
    ): NetworkResponse<CommonBaseResponse<UpdatePhotoProfileResponse>, CommonErrorResponse>

    @FormUrlEncoded
    @POST("user/refresh-token")
    suspend fun refreshToken(
        @Field("refresh_token") refreshToken: String,
    ): NetworkResponse<CommonBaseResponse<RefreshTokenResponse>, CommonErrorResponse>

    @Multipart
    @PATCH("user/me/profile-img")
    suspend fun updateProfileImage(
        @Header("Authorization") authorization: String,
        @Part profileImg: MultipartBody.Part
    ): NetworkResponse<UpdateProfileImageResponse, CommonErrorResponse>

}