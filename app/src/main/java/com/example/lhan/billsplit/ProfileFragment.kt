package com.example.lhan.billsplit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlin.math.log
import android.R.id.edit
import android.content.SharedPreferences
import android.preference.PreferenceManager



class ProfileFragment : Fragment() {
    private var logoutButton: Button? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        logoutButton = view.findViewById(R.id.btn_logout)

        logoutButton!!.setOnClickListener {
            val preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity())
            val editor = preferences.edit()
            editor.putBoolean("logged", false)

            editor.apply()

            activity!!.supportFragmentManager.beginTransaction()
                .add(R.id.container, ProfileFragment())
                .commit()
        }
        return view
    }

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }
}
