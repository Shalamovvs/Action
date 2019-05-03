package com.example.filmapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_page2.*
import kotlinx.android.synthetic.main.movie_list.*
import kotlinx.android.synthetic.main.movie_list.view.*

class Page2 : AppCompatActivity() {

    val nameList:ArrayList<Model> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)
        recyclerView_Second.layoutManager = LinearLayoutManager(this)
        recyclerView_Second.adapter = MainAdapter(nameList)
    }

    fun openPage(view: View)
    {
        val changePage = Intent(this, MainActivity::class.java)
        startActivity(changePage)
    }
    fun restart(view: View)
    {
        recyclerView_Second.removeAllViewsInLayout();
    }

    fun sendDetails(view: View)
    {
        var filmTitles = textName.text
        var filmYear = textYear.text
        nameList.add(Model(filmTitles.toString(),filmYear.toString()))
        recyclerView_Second.adapter!!.notifyDataSetChanged()
    }

}
