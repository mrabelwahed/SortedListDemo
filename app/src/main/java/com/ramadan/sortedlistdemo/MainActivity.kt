package com.ramadan.sortedlistdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    fun RecyclerView.setup(context: Context) {
        this.layoutManager = LinearLayoutManager(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).also { it.setup(this) }
        val adapter = UsersAdapter()
        recyclerView.adapter = adapter

        adapter.addUsers(DataGenerator.generateBulkUsers())

        findViewById<View>(R.id.byAge).setOnClickListener{
            adapter.changeSortType(Order.AgeOrder())
        }

        findViewById<View>(R.id.byScore).setOnClickListener{
            adapter.changeSortType(Order.ScoreOrder())
        }
    }
}