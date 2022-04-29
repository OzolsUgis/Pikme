package com.ugisozols.setup_domain.use_cases

import android.util.Log
import com.ugisozols.core.domain.Preferences
import com.ugisozols.setup_domain.repository.UserUpdateRepository
import javax.inject.Inject

class UpdateUsernameUseCase @Inject constructor(
    private val preferences: Preferences,
    private val repository: UserUpdateRepository
) {
    suspend operator fun invoke(username : String){
        val userId = preferences.loadUserId() ?: ""
        repository.updateUsername(userId,username)
    }
}