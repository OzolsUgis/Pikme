package com.ugisozols.setup_presentation.username_update_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugisozols.core.navigation.Route
import com.ugisozols.core.util.UiEvent
import com.ugisozols.core.util.UiText
import com.ugisozols.setup_domain.repository.UserUpdateRepository
import com.ugisozols.core.R
import com.ugisozols.setup_domain.use_cases.UpdateUsernameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateUsernameScreenViewModel @Inject constructor(
    private val useCase: UpdateUsernameUseCase
) : ViewModel() {

    var name = mutableStateOf("")
    private set

    var inputError = mutableStateOf(false)
    private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun onUsernameValueChange(newValue : String){
        name.value = newValue
    }

    fun onEvent(events: UpdateUsernameScreenEvents){
        when(events){
            UpdateUsernameScreenEvents.OnNextClick ->{
                viewModelScope.launch {
                    if(name.value.isNotBlank()){
                        useCase(name.value)
                        _uiEvent.send(
                            UiEvent.Navigate(
                                Route.UPDATE_IMAGE
                            )
                        )
                    }else{
                        inputError.value = true
                        _uiEvent.send(
                            UiEvent.ShowSnackbar(
                                UiText.StringResource(R.string.input_error_field_empty)
                            )
                        )
                    }

                }
            }
        }
    }

}