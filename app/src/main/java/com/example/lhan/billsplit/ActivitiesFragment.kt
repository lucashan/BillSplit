package com.example.lhan.billsplit

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_activities.view.*

class ActivitiesFragment : Fragment() {
    private lateinit var activitiesViewModel: ActivitiesViewModel
    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_activities_list, container, false)
        activitiesViewModel = ViewModelProviders.of(activity!!).get(ActivitiesViewModel::class.java)
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> android.support.v7.widget.LinearLayoutManager(context)
                    else -> android.support.v7.widget.GridLayoutManager(context, columnCount)
                }
                adapter = ActivitiesRecyclerViewAdapter(context, activitiesViewModel.ITEMS)
            }
        }
        return view
    }

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            ActivitiesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    /* -------------------------------------- Activities RecyclerView Adapter --------------------------------------- */

    class ActivitiesRecyclerViewAdapter(context: Context, private val mValues: MutableList<ActivitiesViewModel.HouseBill>) :
        RecyclerView.Adapter<ActivitiesRecyclerViewAdapter.ViewHolder>() {
        private val onClickListener: View.OnClickListener
        private val mainActivity: MainActivity = context as MainActivity
        /* Display the options to either pay or delete bill */
        init {
            onClickListener = View.OnClickListener { v ->
                val actionBillFragment = ActionBillFragment()
                actionBillFragment.show(mainActivity.supportFragmentManager,"action_fragment")
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
}
