package com.example.filmapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso;
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/ueSrJOArD6Ylp6q3kh2WD1jbqm0.jpg").into(im1);
        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/aRojIU7zpIqAqiM9Wuj4DX6ALKP.jpg").into(im3);
        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/zHmfOXRgcUb2Sd79bttsZNokYbS.jpg").into(im4);
        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrWK7kZPDlYsgGg8b2SuBCYH4yw.jpg").into(im2);
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
