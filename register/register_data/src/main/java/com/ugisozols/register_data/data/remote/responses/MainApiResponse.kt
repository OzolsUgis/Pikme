package com.ugisozols.register_data.data.remote.responses

data class MainApiResponse<T>(
    val successful : Boolean,
    val message : String? = null,
    val data : T? = null
)
