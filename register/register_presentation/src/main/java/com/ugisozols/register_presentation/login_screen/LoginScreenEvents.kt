package com.ugisozols.register_presentation.login_screen

import com.ugisozols.core.navigation.Route

sealed class LoginScreenEvents {
    object OnLoginClick : LoginScreenEvents()
}