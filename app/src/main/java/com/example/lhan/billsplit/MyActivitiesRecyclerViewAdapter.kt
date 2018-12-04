package com.example.lhan.billsplit

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_activities.view.*

class MyActivitiesRecyclerViewAdapter(
    private val mValues: MutableList<ActivitiesViewModel.HouseBill>) : RecyclerView.Adapter<MyActivitiesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_activities, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mUserView.text = item.user
        holder.mContentView.text = item.content
        holder.mPriceView.text = item.price
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mUserView: TextView = mView.user
        val mContentView: TextView = mView.content
        val mPriceView: TextView = mView.price

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
