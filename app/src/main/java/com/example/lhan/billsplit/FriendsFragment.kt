package com.example.lhan.billsplit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FriendsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_friends, container, false)

    companion object {
        fun newInstance(): FriendsFragment = FriendsFragment()
    }
}
