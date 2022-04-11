package com.ugisozols.register_data.repository


import android.util.Log
import com.ugisozols.core.util.Resource
import com.ugisozols.core.util.UiText
import com.ugisozols.core.R
import com.ugisozols.register_data.data.remote.UserApi
import com.ugisozols.register_data.data.remote.requests.AccountRequest
import com.ugisozols.register_domain.repository.UserRepository
import kotlinx.coroutines.delay
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api : UserApi
) : UserRepository{
    override suspend fun register(
        email: String,
        password: String,
        confPassword: String
    ) : Resource<UiText>{
        return try {
            val response = api.register(AccountRequest(email,password,confPassword))
            Resource.Success(UiText.DynamicString(response.body()?.message.orEmpty()))

        }catch (e : IOException){
            e.printStackTrace()
            Resource.Error(
                UiText.StringResource(R.string.io_exception)
            )
        }catch (e: HttpException){
            e.printStackTrace()
            Resource.Error(
                UiText.StringResource(R.string.http_exception)
            )
        }
    }
}