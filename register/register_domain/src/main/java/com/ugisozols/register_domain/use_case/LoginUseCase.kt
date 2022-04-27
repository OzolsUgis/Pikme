package com.ugisozols.register_domain.use_case

import com.ugisozols.core.data.api_responses.LoginResponse
import com.ugisozols.core.util.Resource
import com.ugisozols.core.util.UiText
import com.ugisozols.register_domain.repository.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository : UserRepository
){
    suspend operator fun invoke(email : String, password : String) : Resource<LoginResponse>{
        val trimmedEmail = email.trim().lowercase()
        val trimmedPassword = password.trim()

        return repository.login(trimmedEmail, trimmedPassword)
    }
}