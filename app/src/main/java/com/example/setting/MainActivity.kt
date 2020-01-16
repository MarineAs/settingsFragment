package com.example.setting

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : FragmentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager:FragmentManager=supportFragmentManager
        val transaction:FragmentTransaction=manager.beginTransaction()
        transaction.replace(R.id.fragmentContainer,SettingsFragment.getInstance())
        transaction.commit()

    }
}
