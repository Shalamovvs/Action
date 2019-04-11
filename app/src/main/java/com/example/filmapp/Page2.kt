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
    var numbers = 0
    fun sendDetails(view: View)
    {
        numbers += 1
        val filmTitles = textName
        val filmYear = textYear
        //var film_view_title = emptyArray<EditText>()
        //var film_view_year = emptyArray<EditText>()
        intent.putExtra("numbers", numbers)
        //film_view_title[numbers].text = filmTitles.text
        //film_view_year[numbers].text = filmTitles.text
        film_view_title.text = filmTitles.text
        film_view_year.text = filmYear.text
    }

}
