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
}