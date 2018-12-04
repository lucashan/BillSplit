package com.example.lhan.lab5.dummy

import java.util.*

object LHanDataStore {

    /**
     * An array of sample house bills.
     */
    val ITEMS: MutableList<HouseBill> = ArrayList()

    /**
     * A map of sample house bills, by ID.
     */
    val ITEM_MAP: MutableMap<String, HouseBill> = HashMap()

    fun addItem(item: HouseBill) {
        ITEMS.add(item)
        ITEM_MAP.put(item.user, item)
    }

    fun deleteItem(item: HouseBill) {
        ITEMS.remove(item)
        ITEM_MAP.remove(item.user)
    }

    fun editItem(item: HouseBill){
        ITEMS.set(0, item)
        ITEM_MAP.set(item.user, item)
    }

    fun createHouseBill(user : String, content : String, price : String): HouseBill {
        return HouseBill(makeUser(user), makeBill(content), makePrice(price))
    }
    // creates user
    fun makeUser(user : String): String {
        val builder = StringBuilder()
        builder.append(user)
        return builder.toString()
    }
    // creates bill
    fun makeBill(bill : String): String {
        val builder = StringBuilder()
        builder.append(bill)
        return builder.toString()
    }
    // creates type
    fun makePrice(price : String): String {
        val builder = StringBuilder()
        builder.append(price)
        return builder.toString()
    }

    /**
     * A house bill representing a piece of content.
     */
    data class HouseBill(val user: String, val content: String, val price: String) {
        override fun toString(): String = content
    }
}