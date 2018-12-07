package com.example.lhan.billsplit

import android.os.Bundle
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class GroupsFragment : ListFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val names = arrayOf("name1", "name2")
        val adapter : ArrayAdapter<String> = ArrayAdapter(inflater.context, android.R.layout.simple_list_item_1, names)
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        fun newInstance(): GroupsFragment = GroupsFragment()
    }
}

