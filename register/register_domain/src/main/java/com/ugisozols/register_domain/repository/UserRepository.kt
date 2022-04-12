package com.ugisozols.register_domain.repository

import com.ugisozols.core.util.Resource
import com.ugisozols.core.util.UiText
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun register(email : String, password : String, confPassword : String) : Resource<UiText>
    suspend fun login(email : String, password: String) : Resource<UiText>
}