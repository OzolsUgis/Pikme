package com.ugisozols.register_data.data.remote

import com.ugisozols.core.data.api_responses.LoginResponse
import com.ugisozols.register_data.data.remote.requests.AccountRequest
import com.ugisozols.register_data.data.remote.requests.LoginRequest
import com.ugisozols.core.data.api_responses.MainApiResponse
import retrofit2.Response

import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("api/user/create")
    suspend fun register(
        @Body accountRequest: AccountRequest
    ) : Response<MainApiResponse<Unit>>

    @POST("api/user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<MainApiResponse<LoginResponse>>


}