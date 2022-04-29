package com.ugisozols.setup_data.data

import android.util.Log
import com.ugisozols.core.domain.Preferences
import com.ugisozols.core.util.Resource
import com.ugisozols.core.util.UiText
import com.ugisozols.setup_data.R

import com.ugisozols.setup_data.data.remote.UserUpdateApi
import com.ugisozols.setup_domain.repository.UserUpdateRepository
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class UserUpdateRepositoryImpl @Inject constructor(
    private val api: UserUpdateApi
    ) : UserUpdateRepository {


    override suspend fun updateUsername(userId : String, username: String): Resource<UiText> {

        return try {
            if (username.isNotBlank()) {
               api.updateUsername(userId, username)
            }
            Resource.Success(UiText.StringResource(com.ugisozols.core.R.string.username_updated))
        } catch (e: IOException) {
            Resource.Error<UiText>(
                UiText.StringResource(com.ugisozols.core.R.string.io_exception)
            )
        } catch (e: HttpException) {
            Resource.Error<UiText>(
                UiText.StringResource(com.ugisozols.core.R.string.http_exception)
            )
        }
    }


    override suspend fun updateUserImg(userId: String, image: String): Resource<UiText> {
        TODO("Not yet implemented")
    }

}