package com.example.lhan.billsplit

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_activities.view.*

class ActivitiesRecyclerViewAdapter(private val mValues: MutableList<ActivitiesViewModel.HouseBill>) :
    RecyclerView.Adapter<ActivitiesRecyclerViewAdapter.ViewHolder>() {
    private val onClickListener: View.OnClickListener
    init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as ActivitiesViewModel.HouseBill
            val intent = Intent(v.context, ActivitiesDetailActivity::class.java).apply {
                putExtra(ActivitiesDetailFragment.ARG_ITEM_ID, item.user)
            }
            v.context.startActivity(intent)
        }
    }
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
        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val mUserView: TextView = mView.user
        val mContentView: TextView = mView.content
        val mPriceView: TextView = mView.price
    }
}
