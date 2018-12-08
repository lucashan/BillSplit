package com.example.lhan.billsplit

import android.R
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class FriendsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val names = arrayOf("John", "Kevin", "Chris", "Daniel")
//        val adapter : ArrayAdapter<String> = ArrayAdapter(inflater.context, R.layout.simple_list_item_1, names)
//        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        fun newInstance(): FriendsFragment = FriendsFragment()
    }
}
