package com.ugisozols.setup_domain.repository

import com.ugisozols.core.util.Resource
import com.ugisozols.core.util.UiText

interface UserUpdateRepository {
    suspend fun updateUsername(userId : String,username : String) : Resource<UiText>
    suspend fun updateUserImg(userId : String, image : String) : Resource<UiText>
}