package com.example.setting

import android.content.SharedPreferences

class PreferencesManager(private val sharedPreferences: SharedPreferences) : IPreferencesManager {

    override var lightToggle: Boolean
        get() = sharedPreferences.getBoolean("lightMode", false)
        set(value) {
            sharedPreferences.edit().putBoolean("lightMode", value).apply()
        }

    override var clMode: Boolean
        get() = sharedPreferences.getBoolean("clMode", true)
        set(value) {
            sharedPreferences.edit().putBoolean("clMode", value).apply()

        }

    override var intMode: Boolean
        get() = sharedPreferences.getBoolean("intMode", false)
        set(value) {
            sharedPreferences.edit().putBoolean("intMode", value).apply()
        }

    override var hqMode: Boolean
        get() = sharedPreferences.getBoolean("hqMode", false)
        set(value) {
            sharedPreferences.edit().putBoolean("hqMode", value).apply()
        }

}
interface IPreferencesManager {
    var lightToggle: Boolean
    var clMode: Boolean
    var intMode: Boolean
    var hqMode: Boolean
}
