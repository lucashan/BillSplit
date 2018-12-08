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
import kotlinx.android.synthetic.main.fragment_action_bill.view.*

class ActionBillFragment : DialogFragment() {

    private val activitiesViewModel: ActivitiesViewModel by lazy {
        ViewModelProviders.of(activity!!).get(ActivitiesViewModel::class.java)
    }
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
        payBill()
        return root
    }
    private fun payBill() {
        /* Add bill information */
        payButton!!.setOnClickListener {
            val intent = Intent(context, StripeActivity::class.java)
            startActivity(intent)
            dismiss()
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
