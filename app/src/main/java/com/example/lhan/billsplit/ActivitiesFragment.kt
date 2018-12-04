package com.example.lhan.billsplit

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.recyclerview.R.attr.layoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
//import com.example.lhan.billsplit.ItemDetailFragment.Companion.ARG_ITEM_ID
import com.example.lhan.billsplit.dummy.DummyContent
import com.example.lhan.lab5.dummy.LHanDataStore
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.fragment_activities.*
import kotlinx.android.synthetic.main.item_detail.view.*


class ActivitiesFragment : Fragment() {
    private var item: LHanDataStore.HouseBill? = null
    private lateinit var activitiesViewModel: ActivitiesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_activities, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (LHanDataStore.ITEMS.isNotEmpty()){
            user.text = LHanDataStore.ITEMS[0].user
            content.text = LHanDataStore.ITEMS[0].content
            price.text = LHanDataStore.ITEMS[0].price
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activitiesViewModel = ViewModelProviders.of(this).get(ActivitiesViewModel::class.java)
        // TODO: Use the ViewModel
    }
    companion object {
        fun newInstance(): ActivitiesFragment = ActivitiesFragment()
    }
//
//    // TODO: Customize parameters
//    private var columnCount = 1
//
//    private var listener: OnListFragmentInteractionListener? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        arguments?.let {
//            columnCount = it.getInt(ARG_COLUMN_COUNT)
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_activities, container, false)
//
//        // Set the adapter
//        if (view is RecyclerView) {
//            with(view) {
//                layoutManager = when {
//                    columnCount <= 1 -> android.support.v7.widget.LinearLayoutManager(context)
//                    else -> android.support.v7.widget.GridLayoutManager(context, columnCount)
//                }
//                adapter = MyActivitiesRecyclerViewAdapter(LHanDataStore.ITEMS, listener)
//            }
//        }
//        return view
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnListFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     *
//     *
//     * See the Android Training lesson
//     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
//     * for more information.
//     */
//    interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onListFragmentInteraction(item: LHanDataStore.HouseBill?)
//    }
//
//    companion object {
//
//        // TODO: Customize parameter argument names
//        const val ARG_COLUMN_COUNT = "column-count"
//
//        // TODO: Customize parameter initialization
//        @JvmStatic
//        fun newInstance(columnCount: Int) =
//            ActivitiesFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_COLUMN_COUNT, columnCount)
//                }
//            }
//    }

}
