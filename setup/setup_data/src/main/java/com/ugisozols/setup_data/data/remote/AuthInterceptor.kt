package com.ugisozols.setup_data.data.remote

import com.ugisozols.core.domain.Preferences
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val preferences: Preferences
): Interceptor {

    private val token = preferences.loadAuthToken() ?: ""



    override fun intercept(chain: Interceptor.Chain): Response {
        val authRequest = chain.request().newBuilder()
            .addHeader(
                "Bearer",
                token
            ).build()
        return chain.proceed(authRequest)
    }
}