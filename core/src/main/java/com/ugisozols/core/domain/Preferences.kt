package com.ugisozols.core.domain

interface Preferences {
     fun saveIsLoggedIn(isLoggedIn : Boolean)
     fun loadIsLoggedIn() : Boolean



     companion object {
         const val  KEY_LOGGED_IN = "logged_in"
     }
}