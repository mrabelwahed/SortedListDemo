package com.ramadan.sortedlistdemo

class Order {

    class AgeOrder : Comparator<User> {

        override fun compare(user: User, t1: User): Int {
            return user.age - t1.age
        }
    }

    class ScoreOrder : Comparator<User> {
        override fun compare(user: User, t1: User): Int {
            return user.score - t1.score
        }
    }

    class NameOrder :Comparator<User>{
        override fun compare(user1: User, user2: User): Int {
            return  user1.name.compareTo(user2.name)
        }

    }
}