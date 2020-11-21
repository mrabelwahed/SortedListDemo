package com.ramadan.sortedlistdemo

import androidx.recyclerview.widget.RecyclerView

class UserSortedListImpl(adapter: RecyclerView.Adapter<*>) : SortedListComparatorWrapper<User>(adapter, UserSortedListImpl.DEFAULT_ORDER) {

    companion object {
        private val DEFAULT_ORDER = Order.NameOrder().then(Order.ScoreOrder())
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(item1: User, item2: User): Boolean {
        return item1.id == item2.id
    }
}
