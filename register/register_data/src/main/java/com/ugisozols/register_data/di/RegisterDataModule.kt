package com.ugisozols.register_data.di

import com.google.gson.Gson
import com.ugisozols.register_data.data.remote.UserApi
import com.ugisozols.register_data.repository.UserRepositoryImpl
import com.ugisozols.register_domain.repository.UserRepository
import com.ugisozols.register_domain.use_case.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RegisterDataModule {

    @Provides
    @Singleton
    fun provideUserApi() : UserApi {
        return Retrofit.Builder()
            .baseUrl(UserApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        api : UserApi
    ): UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRegisterUseCase(
        repository: UserRepository
    ): RegisterUseCase {
        return RegisterUseCase(repository)
    }
}