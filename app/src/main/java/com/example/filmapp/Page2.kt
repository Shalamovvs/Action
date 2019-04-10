package com.example.filmapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_page2.*

class Page2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        recyclerView_Second.layoutManager = LinearLayoutManager(this)
        recyclerView_Second.adapter = MainAdapter()
    }

    fun openPage(view: View)
    {
        val changePage = Intent(this, MainActivity::class.java)
        startActivity(changePage)
    }
}
