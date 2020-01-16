package com.example.setting.viewModel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.setting.PreferencesManager


class SettingsViewModel(private val pref: PreferencesManager) : ViewModel() {

    val lightMode: MutableLiveData<Boolean> = MutableLiveData(pref.lightToggle)
    val hqMode: MutableLiveData<Boolean> = MutableLiveData(pref.hqMode)
    val clMode: MutableLiveData<Boolean> = MutableLiveData(pref.clMode)
    val intMode: MutableLiveData<Boolean> = MutableLiveData(pref.intMode)

    fun switchLightMode() {
        if (lightMode.value == false) {
            lightMode.value = true
            pref.lightToggle = true
        } else {
            lightMode.value = false
            pref.lightToggle = false
        }
    }

    fun switchHQMode() {
        if (hqMode.value == false) {
            hqMode.value = true
            pref.hqMode = true

        } else {
            hqMode.value = false
            pref.hqMode = false
        }
    }

    fun checkedClassicMode() {
        if (clMode.value == false) {
            clMode.value = true
            intMode.value = false
            pref.clMode = true
            pref.intMode = false
        }
    }

    fun checkedInteractiveMode() {
        if (intMode.value == false) {
            clMode.value = false
            intMode.value = true
            pref.clMode = false
            pref.intMode = true
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

}

