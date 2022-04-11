package com.ugisozols.register_presentation.register_screen

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugisozols.core.util.Resource
import com.ugisozols.core.util.UiEvent
import com.ugisozols.core.util.UiText
import com.ugisozols.register_domain.use_case.RegisterUseCase
import com.ugisozols.core.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationScreenViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    var email = mutableStateOf("")
        private set


    var password = mutableStateOf("")
        private set


    var confirmedPassword = mutableStateOf("")
        private set

    var registrationLoading = mutableStateOf(false)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun setEmail(emailInput : String){
        email.value = emailInput
    }
    fun setPassword(passwordInput : String){
        password.value = passwordInput
    }
    fun setConfPassword(passwordInput: String){
        confirmedPassword.value = passwordInput
    }

    fun onEvent(event : RegistrationScreenEvents){
        when(event){
            RegistrationScreenEvents.OnRegisterClick -> {
                viewModelScope.launch {
                   val registration = registerUseCase(
                        email.value,
                        password.value,
                        confirmedPassword.value
                    )
                    when(registration){
                        is Resource.Error -> {
                            registrationLoading.value = false

                            _uiEvent.send(
                                UiEvent.ShowSnackbar(
                                    registration.data ?: UiText.StringResource(
                                        R.string.http_exception
                                    )
                                )
                            )
                        }
                        is Resource.Success -> {
                            registrationLoading.value = false
                            _uiEvent.send(
                                UiEvent.ShowSnackbar(
                                    registration.data ?: UiText.StringResource(
                                        R.string.user_register_successful
                                    )
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}