package com.ugisozols.core.data.api_responses

data class MainApiResponse<T>(
    val successful : Boolean,
    val message : String? = null,
    val data : T? = null
)
