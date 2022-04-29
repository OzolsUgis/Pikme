package com.ugisozols.core.data

import android.content.SharedPreferences
import com.ugisozols.core.domain.Preferences

class PreferencesImpl(
    private val sharedPref: SharedPreferences
) : Preferences {

    override fun saveIsLoggedIn(isLoggedIn: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_LOGGED_IN,isLoggedIn)
            .apply()
    }

    override fun loadIsLoggedIn(): Boolean {
        return sharedPref.getBoolean(
            Preferences.KEY_LOGGED_IN,
            true
        )
    }

    override fun saveLoggedEmail(email: String) {
        sharedPref.edit()
            .putString(Preferences.KEY_LOGGED_EMAIL,email)
            .apply()
    }

    override fun loadLoggedInEmail(): String? {
        return sharedPref.getString(
            Preferences.KEY_LOGGED_EMAIL,
            null
        )
    }

    override fun saveAuthToken(token: String) {
        sharedPref.edit()
            .putString(Preferences.KEY_AUTH_TOKEN,token)
            .apply()
    }


    override fun loadAuthToken(): String? {
        return sharedPref.getString(
            Preferences.KEY_AUTH_TOKEN,
            null
        )
    }

    override fun saveUserId(string: String) {
        sharedPref.edit()
            .putString(Preferences.KEY_USERID,string)
            .apply()
    }

    override fun loadUserId(): String? {
        return sharedPref.getString(
            Preferences.KEY_USERID,
            null
        )
    }
}