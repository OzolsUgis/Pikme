package com.ugisozols.register_presentation.login_screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugisozols.core.R
import com.ugisozols.core.navigation.Route
import com.ugisozols.core.util.Resource
import com.ugisozols.core.util.UiEvent
import com.ugisozols.core.util.UiText
import com.ugisozols.register_domain.use_case.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val useCases: UserUseCases
) : ViewModel() {
    var email = mutableStateOf("")
        private set

    var password = mutableStateOf("")
        private set

    var isLoading = mutableStateOf(false)

    private var _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun setEmail(emailInput: String) {
        email.value = emailInput
    }

    fun setPassword(passwordInput: String) {
        password.value = passwordInput
    }

    fun onRegisterClick(){
        viewModelScope.launch {
            _uiEvent.send(UiEvent.Navigate(route = Route.REGISTER))
        }
    }

    fun onEvent(event: LoginScreenEvents) {
        when (event) {
            LoginScreenEvents.OnLoginClick -> {
                viewModelScope.launch {
                    val login = useCases.login(
                        email.value,
                        password.value
                    )
                    when (login) {
                        is Resource.Error -> {
                            isLoading.value = false
                            _uiEvent.send(
                                UiEvent.ShowSnackbar(
                                    login.message ?: UiText.StringResource(
                                        R.string.http_exception
                                    )
                                )
                            )
                        }
                        is Resource.Loading -> {
                            isLoading.value = true
                        }
                        is Resource.Success -> {
                            isLoading.value = false
                            _uiEvent.send(
                                UiEvent.Navigate(Route.NEXT)
                            )
                        }
                    }
                }
            }
        }
    }
}
