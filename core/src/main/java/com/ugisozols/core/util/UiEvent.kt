package com.ugisozols.core.util

import com.ugisozols.core.navigation.Route

sealed class UiEvent {
    data class ShowSnackbar(val message : UiText): UiEvent()
    data class Navigate(val route : String): UiEvent()
}
