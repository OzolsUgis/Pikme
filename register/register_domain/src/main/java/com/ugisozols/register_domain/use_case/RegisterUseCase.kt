package com.ugisozols.register_domain.use_case

import com.ugisozols.core.util.Resource
import com.ugisozols.core.util.UiText
import com.ugisozols.register_domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RegisterUseCase(
    private val repository : UserRepository
) {
    suspend operator fun invoke(
        email : String,
        password : String,
        confPassword: String
    ) : Resource<UiText> {
        return repository.register(email, password, confPassword)
    }
}