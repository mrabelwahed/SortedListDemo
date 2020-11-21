package com.ramadan.sortedlistdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SortedList

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
  private val userSortedList : SortedList<User>
    private val sortedListComparatorWrapper: SortedListComparatorWrapper<User>

    init {
        sortedListComparatorWrapper = UserSortedListImpl(this)
        userSortedList = SortedList(User::class.java, SortedList.BatchedCallback<User>(sortedListComparatorWrapper))
    }

    class UserViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView) {
        var textViewUsername: TextView = itemView.findViewById(R.id.textViewUserName)
        var textViewBirthDate: TextView = itemView.findViewById(R.id.textViewBirthDate)
        var textViewScore: TextView = itemView.findViewById(R.id.textViewScore)

        fun setUser(user: User) {
            textViewUsername.text = user.name
            textViewBirthDate.text = "Age: " + user.age
            textViewScore.text = "Score:" + user.score
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userSortedList.size()
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.setUser(userSortedList.get(position))
    }

    fun addUsers(users: List<User>) {
        with(userSortedList) {
            beginBatchedUpdates()
            addAll(users)
            endBatchedUpdates()
        }
    }
    fun changeSortType(comparator: Comparator<User>) {
        with(userSortedList) {
            sortedListComparatorWrapper.setComparator(comparator)
            beginBatchedUpdates()
            val tempUsers = (0 until userSortedList.size()).mapTo(ArrayList<User>()) { get(it) }
            clear()
            addAll(tempUsers)
            tempUsers.clear()
            endBatchedUpdates()
        }
    }
}