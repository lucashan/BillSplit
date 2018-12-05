package com.example.lhan.billsplit

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_activities_detail.*

class ActivitiesDetailActivity : AppCompatActivity() {
    private var deleteButton: Button? = null
    private var editButton: Button? = null
    private val activitiesViewModel: ActivitiesViewModel by lazy {
        ViewModelProviders.of(this).get(ActivitiesViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities_detail)
//        setSupportActionBar(detail_toolbar)
        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val fragment = ActivitiesDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(
                        ActivitiesDetailFragment.ARG_ITEM_ID,
                        intent.getStringExtra(ActivitiesDetailFragment.ARG_ITEM_ID)
                    )
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
        init()
        deleteData()
        editData()
    }
    private fun init() {
        deleteButton = findViewById(R.id.deleteEntry)
        editButton = findViewById(R.id.editEntry)
    }

    private fun deleteData() {
        deleteButton!!.setOnClickListener {
            Toast.makeText(this@ActivitiesDetailActivity, "Successfully deleted.", Toast.LENGTH_SHORT).show()
            activitiesViewModel.deleteItem(ActivitiesViewModel.HouseBill("1", "2", "3"))
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun editData() {
        editButton!!.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {

            NavUtils.navigateUpTo(this, Intent(this, ActivitiesFragment::class.java))
            true
        }
        else -> super.onOptionsItemSelected(item)
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

