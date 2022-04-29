package com.ugisozols.setup_data.data.remote

import android.util.Log
import com.ugisozols.core.domain.Preferences
import com.ugisozols.core.util.Constants.AUTHORIZATION
import com.ugisozols.core.util.Constants.BEARER
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val preferences: Preferences
): Interceptor {

    private val token = preferences.loadAuthToken() ?: ""

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
            .addHeader(AUTHORIZATION, BEARER + token )
            .build()

        return chain.proceed(requestBuilder)
    }
}