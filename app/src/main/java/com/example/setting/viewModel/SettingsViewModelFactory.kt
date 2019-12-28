package com.example.setting.viewModel


import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class SettingsViewModelFactory(private val pref: SharedPreferences) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SharedPreferences::class.java).newInstance(pref)
    }

}
