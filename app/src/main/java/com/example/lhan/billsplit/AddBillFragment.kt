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
import com.example.lhan.billsplit.R.id.*
import com.example.lhan.lab5.dummy.LHanDataStore
import kotlinx.android.synthetic.main.fragment_add_bill.*
import java.nio.channels.Selector

class AddBillFragment : DialogFragment() {

    private lateinit var itemSelector: Selector
    private var activitiesModel : ActivitiesViewModel? = null
    private var addButton: Button? = null
    private var cancelButton: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_add_bill, container, false)
        addButton = root.findViewById(R.id.AddButton)
        cancelButton = root.findViewById(R.id.CancelButton)

        activitiesModel = ViewModelProviders.of(activity!!).get(ActivitiesViewModel::class.java)
        addBill()
        return root
    }

    private fun addBill() {
        /* Add bill information */
        addButton!!.setOnClickListener {
            val user = LHanDataStore.makeUser(addUser!!.text.toString())
            val content = LHanDataStore.makeBill(addContent!!.text.toString())
            val price = LHanDataStore.makePrice(addPrice!!.text.toString())
            if (user.isNullOrEmpty() || content.isNullOrEmpty() || price.isNullOrEmpty())
                Toast.makeText(activity, "Error: Fill out the fields.", Toast.LENGTH_SHORT).show()
            else{
                Toast.makeText(activity, "Successfully added.", Toast.LENGTH_SHORT).show()
                LHanDataStore.addItem(LHanDataStore.createHouseBill(user, content, price))
                dismiss()
            }
//            fragTextView.text = sum.toString()
//            (activity as AddDialogFragmentListener).onAddDialogClick(sum)
        }

        /* Cancel bill information */
        cancelButton!!.setOnClickListener {
            dismiss()
        }
    }

//    interface AddDialogFragmentListener {
//        fun onAddDialogClick(value : Int)
//    }

}
