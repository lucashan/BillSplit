package com.example.lhan.billsplit

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    lateinit var toolbar: ActionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val friendsFragment = FriendsFragment.newInstance(1)
        openFragment(friendsFragment)
        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_friends -> {
                toolbar.title = "Friends"
                val friendsFragment = FriendsFragment.newInstance(1)
                openFragment(friendsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_groups -> {
                toolbar.title = "Groups"
                val groupsFragment = GroupsFragment.newInstance()
                openFragment(groupsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_add -> {
                val addBillFragment = AddBillFragment()
                addBillFragment.show(supportFragmentManager,"add_fragment")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_activities -> {
                toolbar.title = "Activities"
                val activitiesFragment = ActivitiesFragment.newInstance(1)
                openFragment(activitiesFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                toolbar.title = "Profile"
                val profileFragment = ProfileFragment.newInstance()
                openFragment(profileFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
        /**
         * This function navigates to the fragment on click
         */
        private fun openFragment(fragment: Fragment) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
}
