package com.ugisozols.setup_data.data.remote

import com.ugisozols.core.data.api_responses.MainApiResponse
import retrofit2.http.POST
import retrofit2.http.Query

interface UserUpdateApi {


    @POST("api/user/update/username")
    suspend fun updateUsername(
        @Query(QUERY_PARAMETER_USERID) userid : String,
        @Query(QUERY_PARAMETER_USERNAME) username : String
    ) : MainApiResponse<Unit>

    @POST("api/user/update/image")
    suspend fun updateImage(
        @Query(QUERY_PARAMETER_USERID) userid : String,
        @Query(QUERY_PARAMETER_USERNAME) username : String
    ) : MainApiResponse<Unit>

    companion object{

        const val  BASE_URL = "http://192.168.0.103:8080"
        const val QUERY_PARAMETER_USERID = "userid"
        const val QUERY_PARAMETER_USERNAME = "username"
    }
}