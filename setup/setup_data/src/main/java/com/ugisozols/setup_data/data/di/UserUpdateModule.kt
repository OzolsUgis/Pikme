package com.ugisozols.setup_data.data.di

import com.ugisozols.core.domain.Preferences
import com.ugisozols.core.util.Constants.BASE_URL
import com.ugisozols.setup_data.data.UserUpdateRepositoryImpl
import com.ugisozols.setup_data.data.remote.AuthInterceptor
import com.ugisozols.setup_data.data.remote.UserUpdateApi
import com.ugisozols.setup_domain.repository.UserUpdateRepository
import com.ugisozols.setup_domain.use_cases.UpdateUsernameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserUpdateModule {



    @Provides
    @Singleton
    fun provideUserUpdateApi(
        authInterceptor: AuthInterceptor
    ) : UserUpdateApi{
        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserUpdateApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserUpdateRepository(
        userUpdateApi: UserUpdateApi
    ): UserUpdateRepository = UserUpdateRepositoryImpl(userUpdateApi)

    @Provides
    @Singleton
    fun provideUpdateUsernameUseCases(
        preferences: Preferences,
        repository: UserUpdateRepository
    ) : UpdateUsernameUseCase = UpdateUsernameUseCase(
        preferences,
        repository
    )

}