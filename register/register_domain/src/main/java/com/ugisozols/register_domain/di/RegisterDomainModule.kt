package com.ugisozols.register_domain.di

import com.ugisozols.register_domain.repository.UserRepository
import com.ugisozols.register_domain.use_case.LoginUseCase
import com.ugisozols.register_domain.use_case.RegisterUseCase
import com.ugisozols.register_domain.use_case.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RegisterDomainModule {

    @ViewModelScoped
    @Provides
    fun provideUserUseCases(
        repository: UserRepository
    ): UserUseCases {
        return UserUseCases(
            login = LoginUseCase(repository),
            register = RegisterUseCase(repository)
        )
    }
}