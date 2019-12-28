package com.example.setting.viewModel


import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SettingsViewModel(private val pref: SharedPreferences) : ViewModel() {

    val lightMode: MutableLiveData<Boolean> = MutableLiveData(pref.getBoolean("lightMode", true))
    val hqMode: MutableLiveData<Boolean> = MutableLiveData(pref.getBoolean("hqMode", false))
    val clMode: MutableLiveData<Boolean> = MutableLiveData(pref.getBoolean("clMode", true))
    val intMode: MutableLiveData<Boolean> = MutableLiveData(pref.getBoolean("intMode", false))

    fun switchLightMode() {
        if (lightMode.value == false) {
            lightMode.value = true
            updatePref("lightMode", true)
        } else {
            lightMode.value = false
            updatePref("lightMode", false)
        }
    }

    fun switchHQMode() {
        if (hqMode.value == false) {
            hqMode.value = true
            updatePref("hqMode", true)
        } else {
            hqMode.value = false
            updatePref("hqMode", false)
        }
    }

    fun checkedClassicMode() {
        if (clMode.value == false) {
            clMode.value = true
            intMode.value = false
            updatePref("clMode", true)
            updatePref("intMode", false)
        }
    }

    fun checkedInteractiveMode() {
        if (intMode.value == false) {
            clMode.value = false
            intMode.value = true
            updatePref("clMode", false)
            updatePref("intMode", true)
        }
    }

    fun moreAboutAs() {
        Log.d("my", "clicked on About As")
    }

    fun moreFeedBack() {
        Log.d("my", "clicked on FeedBack")
    }

    fun moreHelp() {
        Log.d("my", "clicked on Help")
    }

    fun moreTerms() {
        Log.d("my", "clicked on terms ")

    }

    private fun updatePref(variable: String, value: Boolean) {
        val editor = pref.edit()
        editor.putBoolean(variable, value)
        editor.apply()
        editor.commit()
    }
}

