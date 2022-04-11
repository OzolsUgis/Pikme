package com.ugisozols.core.util

sealed class UiEvent {
    data class ShowSnackbar(val message : UiText): UiEvent()
}
