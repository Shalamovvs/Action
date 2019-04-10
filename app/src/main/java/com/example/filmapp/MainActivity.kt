package com.example.filmapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso;
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Picasso.get().load("https://www.kinopoisk.ru/images/film_big/840372.jpg").into(im3);
        Picasso.get().load("https://www.kinopoisk.ru/images/film_big/843650.jpg").into(im1);
        Picasso.get().load("https://www.kinopoisk.ru/images/film_big/693331.jpg").into(im4);
        Picasso.get().load("https://www.kinopoisk.ru/images/film_big/582358.jpg").into(im2);

    }
    fun openPage2(view: View)
    {
        val changePage = Intent(this, Page2::class.java)
        startActivity(changePage)
    }
    fun openPage3(view: View)
    {
        val changePage = Intent(this, Page3::class.java)
        startActivity(changePage)
    }

}
