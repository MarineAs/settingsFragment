package com.example.setting

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.setting.databinding.SettingsFragmentBinding
import com.example.setting.viewModel.SettingsViewModel
import com.example.setting.viewModel.SettingsViewModelFactory


class SettingsFragment : Fragment() {

    private lateinit var factory: SettingsViewModelFactory
    private val preference by lazy {
        PreferencesManager(
            context?.applicationContext!!.getSharedPreferences(
                "MyPref",
                MODE_PRIVATE
            )
        )
    }
    private lateinit var viewModel: SettingsViewModel
    private lateinit var databinding: SettingsFragmentBinding

    companion object {
        fun getInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        factory = SettingsViewModelFactory(preference)
        viewModel =
            ViewModelProviders.of(this, factory).get(SettingsViewModel::class.java)
        databinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.settings_fragment, container, false)
        val view = databinding.root

        return view
    }

    override fun onStart() {
        super.onStart()
        databinding.viewModel = viewModel
        databinding.lifecycleOwner = this
    }
}