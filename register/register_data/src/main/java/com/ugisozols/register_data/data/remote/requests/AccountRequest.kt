package com.ugisozols.register_data.data.remote.requests

data class AccountRequest(
    val email : String,
    val password : String,
    val confirmedPassword : String
)