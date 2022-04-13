package com.ugisozols.pikme.navigation

import androidx.navigation.NavController
import com.ugisozols.core.util.UiEvent

fun NavController.navigate(event : UiEvent.Navigate){
    this.navigate(event.route)
}