package com.example.setting.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.setting.PreferencesManager


class SettingsViewModelFactory(private val pref: PreferencesManager) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PreferencesManager::class.java).newInstance(pref)
    }

}
