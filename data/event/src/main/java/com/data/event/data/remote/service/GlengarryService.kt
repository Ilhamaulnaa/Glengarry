package com.data.event.data.remote.service

import com.data.event.data.remote.request.AddServiceRequest
import com.data.event.data.remote.response.AddServiceResponse
import com.data.event.data.remote.response.ServiceDetailResponse
import com.data.event.data.remote.response.ServiceResponse
import com.glengarry.network.response.CommonBaseResponse
import com.glengarry.network.response.CommonErrorResponse
import com.glengarry.network.response.CommonGetDataResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface GlengarryService {

    @GET("event/media-partner")
    suspend fun getFashion(
        @Query("name") name: String = "",
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0,
        @Query("field") field: String = "",
        @Query("fees") fees: String = "",
        @Query("location") location: String = ""
    ): NetworkResponse<CommonGetDataResponse<List<ServiceResponse>>, CommonErrorResponse>

    @GET("event/media-partner/{id}")
    suspend fun getFashionById(
        @Path("id") id: String
    ): NetworkResponse<CommonBaseResponse<ServiceDetailResponse>, CommonErrorResponse>

    @GET("event/sponsorship")
    suspend fun getElectronic(
        @Query("name") name: String = "",
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0,
        @Query("field") field: String = "",
        @Query("location") location: String = ""
    ): NetworkResponse<CommonGetDataResponse<List<ServiceResponse>>, CommonErrorResponse>

    @GET("event/sponsorship/{id}")
    suspend fun getElectronicById(
        @Path("id") id: String
    ): NetworkResponse<CommonBaseResponse<ServiceDetailResponse>, CommonErrorResponse>

    @GET("event/rentals")
    suspend fun getBook(
        @Query("name") name: String = "",
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0,
        @Query("field") field: String = "",
        @Query("location") location: String = ""
    ): NetworkResponse<CommonGetDataResponse<List<ServiceResponse>>, CommonErrorResponse>

    @GET("event/rentals/{id}")
    suspend fun getBookById(
        @Path("id") id: String
    ): NetworkResponse<CommonBaseResponse<ServiceResponse>, CommonErrorResponse>

    @GET("event/sport")
    suspend fun getSport(
        @Query("name") name: String = "",
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0,
        @Query("field") field: String = "",
        @Query("location") location: String = ""
    ): NetworkResponse<CommonGetDataResponse<List<ServiceResponse>>, CommonErrorResponse>

    @GET("event/sport/{id}")
    suspend fun getSportById(
        @Path("id") id: String
    ): NetworkResponse<CommonBaseResponse<ServiceDetailResponse>, CommonErrorResponse>

    @GET("event/all")
    suspend fun getAllService(
        @Query("name") name: String = "",
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0,
        @Query("service_type") serviceType: String = "",
        @Query("field") field: String = "",
        @Query("location") location: String = "",
        @Query("fees") fees: String = "",
    ): NetworkResponse<CommonGetDataResponse<List<ServiceResponse>>, CommonErrorResponse>

    @GET("ml/recommend/cf")
    suspend fun getRecommendation(
        @Header("Authorization") authorization: String
    ): NetworkResponse<CommonBaseResponse<List<ServiceResponse>>, CommonErrorResponse>

    @GET("ml/recommend/cb/media_partner/{id}")
    suspend fun getRecommendationFashion(
        @Header("Authorization") authorization: String,
        @Path("id") id: String
    ): NetworkResponse<CommonBaseResponse<List<ServiceResponse>>, CommonErrorResponse>

    @GET("ml/recommend/cb/sponsorship/{id}")
    suspend fun getRecommendationElectronic(
        @Header("Authorization") authorization: String,
        @Path("id") id: String
    ): NetworkResponse<CommonBaseResponse<List<ServiceResponse>>, CommonErrorResponse>

    @GET("ml/recommend/cb/rentals/{id}")
    suspend fun getRecommendationBook(
        @Header("Authorization") authorization: String,
        @Path("id") id: String
    ): NetworkResponse<CommonBaseResponse<List<ServiceResponse>>, CommonErrorResponse>

    @GET("ml/recommend/cb/sport/{id}")
    suspend fun getRecommendationSport(
        @Header("Authorization") authorization: String,
        @Path("id") id: String
    ): NetworkResponse<CommonBaseResponse<List<ServiceResponse>>, CommonErrorResponse>

//    @GET("saved")
//    suspend fun getSavedEventService(
//        @Header("Authorization") authorization: String
//    ): NetworkResponse<CommonSavedItemResponse<List<ServiceResponse>>, CommonErrorResponse>

//    @FormUrlEncoded
//    @POST("saved/add")
//    suspend fun saveEventService(
//        @Header("Authorization") authorization: String,
//        @Field("service_id") serviceId: String,
//        @Field("service_type") serviceType: String
//    ): NetworkResponse<CommonBaseResponse<SaveEventServiceResponse>, CommonErrorResponse>

    @DELETE("saved/delete/{id}")
    suspend fun unSaveEventService(
        @Header("Authorization") authorization: String,
        @Path("id") savedId: String,
    ): NetworkResponse<CommonBaseResponse<String>, CommonErrorResponse>

    @POST("event/media-partner")
    suspend fun addFashion(
        @Header("Authorization") authorization: String,
        @Body request: AddServiceRequest
    ): NetworkResponse<CommonBaseResponse<AddServiceResponse>, CommonErrorResponse>

    @POST("event/sponsorship")
    suspend fun addElectronic(
        @Header("Authorization") authorization: String,
        @Body request: AddServiceRequest
    ): NetworkResponse<CommonBaseResponse<AddServiceResponse>, CommonErrorResponse>

    @POST("event/rentals")
    suspend fun addBook(
        @Header("Authorization") authorization: String,
        @Body request: AddServiceRequest
    ): NetworkResponse<CommonBaseResponse<AddServiceResponse>, CommonErrorResponse>

    @POST("event/sport")
    suspend fun addSport(
        @Header("Authorization") authorization: String,
        @Body request: AddServiceRequest
    ): NetworkResponse<CommonBaseResponse<AddServiceResponse>, CommonErrorResponse>
}