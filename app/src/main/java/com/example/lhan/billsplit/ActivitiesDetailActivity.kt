package com.example.lhan.billsplit

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_activities_detail.*
import kotlinx.android.synthetic.main.activity_item_detail.*

class ActivitiesDetailActivity : AppCompatActivity() {
    private var deleteButton: Button? = null
    private var editButton: Button? = null

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
//        deleteData()
//        editData()
    }
    private fun init() {
        deleteButton = findViewById(R.id.deleteEntry)
        editButton = findViewById(R.id.editEntry)
    }

//    private fun deleteData() {
//        deleteButton!!.setOnClickListener {
//            Toast.makeText(this@ActivitiesDetailActivity, "Successfully deleted.", Toast.LENGTH_SHORT).show()
//            val intent = Intent(this@ActivitiesDetailActivity, ItemListActivity::class.java)
//            LHanDataStore.deleteItem(LHanDataStore.HouseBill("1", "Water", "Bill", "Lucas"))
//            startActivity(intent)
//        }
//    }

//    private fun editData() {
//        editButton!!.setOnClickListener {
//            val intent = Intent(this, EditBillActivity::class.java)
//            startActivity(intent)
//        }
//    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {

            NavUtils.navigateUpTo(this, Intent(this, ActivitiesFragment::class.java))
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}

