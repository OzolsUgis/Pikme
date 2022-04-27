package com.ugisozols.core.data.api_responses

data class LoginResponse(
    val userId : String,
    val email : String,
    val token : String
)
