package com.example.lhan.billsplit


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.lhan.lab5.dummy.LHanDataStore
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.view.*

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
//class ItemDetailFragment : Fragment() {
//
//    /**
//     * The dummy content this fragment is presenting.
//     */
//    private var item: LHanDataStore.HouseBill? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        arguments?.let {
//            if (it.containsKey(ARG_ITEM_ID)) {
//                // Load the dummy content specified by the fragment
//                // arguments. In a real-world scenario, use a Loader
//                // to load content from a content provider.
//                item = LHanDataStore.ITEM_MAP[it.getString(ARG_ITEM_ID)]
//                activity?.toolbar_layout?.title = item?.content
//            }
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val rootView = inflater.inflate(R.layout.item_detail, container, false)
//
//        // Show the dummy content as text in a TextView.
//        item?.let {
//            rootView.id_text_detail.text = it.id
//            rootView.type_detail.text = it.type
//            rootView.content_detail.text = it.content
//            rootView.user_detail.text = it.user
//        }
//
//        return rootView
//    }
//
//    companion object {
//        /**
//         * The fragment argument representing the item ID that this fragment
//         * represents.
//         */
//        const val ARG_ITEM_ID = "item_id"
//    }
//}