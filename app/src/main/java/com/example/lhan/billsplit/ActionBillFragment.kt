package com.example.lhan.billsplit

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.lhan.billsplit.ActivitiesDetailFragment.Companion.ARG_ITEM_ID
import com.example.lhan.billsplit.R.id.*
import com.example.lhan.lab5.dummy.LHanDataStore
import com.example.lhan.lab5.dummy.LHanDataStore.addItem
import com.example.lhan.lab5.dummy.LHanDataStore.createHouseBill
import com.example.lhan.lab5.dummy.LHanDataStore.makeBill
import com.example.lhan.lab5.dummy.LHanDataStore.makePrice
import kotlinx.android.synthetic.main.fragment_action_bill.view.*
import kotlinx.android.synthetic.main.fragment_activities_detail.view.*
import kotlinx.android.synthetic.main.fragment_add_bill.*
import java.nio.channels.Selector

class ActionBillFragment : DialogFragment() {

    private val activitiesViewModel: ActivitiesViewModel by lazy {
        ViewModelProviders.of(activity!!).get(ActivitiesViewModel::class.java)
    }
    private val mValues: MutableList<ActivitiesViewModel.HouseBill>? = null
    private var payButton: Button? = null
    private var deleteButton: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_action_bill, container, false)

        root.textView.text = activitiesViewModel.ITEMS[0].user
        root.textView2.text = activitiesViewModel.ITEMS[0].content
        root.textView3.text = activitiesViewModel.ITEMS[0].price

        payButton = root.findViewById(R.id.PayButton)
        deleteButton = root.findViewById(R.id.DeleteButton)
        deleteBill()
        return root
    }
    private fun payBill() {
        /* Add bill information */
        payButton!!.setOnClickListener {
            val user = activitiesViewModel.makeUser(addUser!!.text.toString())
            val content = activitiesViewModel.makeBill(addContent!!.text.toString())
            val price = activitiesViewModel.makePrice(addPrice!!.text.toString())
            if (user.isNullOrEmpty() || content.isNullOrEmpty() || price.isNullOrEmpty())
                Toast.makeText(activity, "Error: Fill out the fields.", Toast.LENGTH_SHORT).show()
            else{
                Toast.makeText(activity, "Successfully added.", Toast.LENGTH_SHORT).show()
                activitiesViewModel.addItem(activitiesViewModel.createHouseBill(user, content, price))
                dismiss()
            }
        }
    }

    private fun deleteBill(){
        /* Delete the bill */
        deleteButton!!.setOnClickListener {
            Toast.makeText(activity, "Successfully deleted.", Toast.LENGTH_SHORT).show()
            activitiesViewModel.deleteItem(ActivitiesViewModel.HouseBill(activitiesViewModel.ITEMS[0].user, activitiesViewModel.ITEMS[0].content, activitiesViewModel.ITEMS[0].price))
            dismiss()
        }
    }
}
