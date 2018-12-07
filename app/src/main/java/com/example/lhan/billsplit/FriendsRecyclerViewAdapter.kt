package com.example.lhan.billsplit

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_activities.view.*

class FriendsRecyclerViewAdapter(private val mValues: MutableList<FriendsViewModel.HouseBill>) :
    RecyclerView.Adapter<FriendsRecyclerViewAdapter.ViewHolder>() {
    private val onClickListener: View.OnClickListener

    init {

        onClickListener = View.OnClickListener { v ->
            val item = v.tag as FriendsViewModel.HouseBill
            val intent = Intent(v.context, ActivitiesDetailActivity::class.java).apply {
                putExtra(ActivitiesDetailFragment.ARG_ITEM_ID, item.user)
            }
            v.context.startActivity(intent)
//            val manager = activity.supportFragmentManager // I cannot resolve activity here
//            val transaction = manager.beginTransaction()
//            transaction.add(R.id.container, AddBillFragment(), "IndividualBook")
//            transaction.addToBackStack(null)
//            transaction.commit()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_friends, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mUserView.text = item.user
        holder.mContentView.text = item.content
        holder.mPriceView.text = item.price
        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    fun removeAt(position: Int) {
        mValues.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val mUserView: TextView = mView.user
        val mContentView: TextView = mView.content
        val mPriceView: TextView = mView.price

    }
}
