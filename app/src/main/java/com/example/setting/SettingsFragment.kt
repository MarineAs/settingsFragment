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
import kotlinx.android.synthetic.main.settings_fragment.*


class SettingsFragment : Fragment() {

    private lateinit var factory: SettingsViewModelFactory
    private val pref: SharedPreferences? by lazy {
        context?.applicationContext
            ?.getSharedPreferences("MyPref", MODE_PRIVATE)
    }
    private lateinit var viewModel: SettingsViewModel

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
        factory = SettingsViewModelFactory(pref!!)
        viewModel =
            ViewModelProviders.of(this, factory).get(SettingsViewModel::class.java)
        val databinding: SettingsFragmentBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.settings_fragment, container, false)
        val view = databinding.root
        databinding.viewModel = viewModel
        databinding.lifecycleOwner = this


        return view
    }
}