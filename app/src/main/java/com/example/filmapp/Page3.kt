package com.example.filmapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Page3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)
    }
    fun openPage(view: View)
    {
        val changePage = Intent(this, MainActivity::class.java)
        startActivity(changePage)
    }
}
