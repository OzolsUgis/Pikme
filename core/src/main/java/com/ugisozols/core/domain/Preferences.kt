package com.ugisozols.core.domain

interface Preferences {
     fun saveIsLoggedIn(isLoggedIn : Boolean)
     fun loadIsLoggedIn() : Boolean
     fun saveLoggedEmail(email : String)
     fun loadLoggedInEmail() : String?

     fun saveAuthToken(token : String)
     fun loadAuthToken() : String?



     companion object {
         const val  KEY_LOGGED_IN = "logged_in"
         const val  KEY_LOGGED_EMAIL = "logged_email"
         const val  KEY_AUTH_TOKEN = "auth_token"
     }
}