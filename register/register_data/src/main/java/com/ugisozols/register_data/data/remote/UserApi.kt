package com.ugisozols.register_data.data.remote

import com.ugisozols.register_data.data.remote.requests.AccountRequest
import com.ugisozols.register_data.data.remote.responses.MainApiResponse
import retrofit2.Response

import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("api/user/create")
    suspend fun register(
        @Body accountRequest: AccountRequest
    ) : Response<MainApiResponse<Unit>>


    companion object {
        const val BASE_URL = "http://192.168.0.103:8008"
    }

}