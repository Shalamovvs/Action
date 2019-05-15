package com.example.filmapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.Gson
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso;
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_page3.*
import kotlinx.android.synthetic.main.movie_base.*
import kotlinx.android.synthetic.main.poster_list.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        posterRecycler.layoutManager = LinearLayoutManager(this)
        posterJson()
        val itemDecoration = DividerItemDecoration(applicationContext,1)
        itemDecoration.setDrawable(ColorDrawable(Color.BLACK))
        posterRecycler.addItemDecoration(itemDecoration)
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

    fun posterJson()
    {
        val url = "https://api.themoviedb.org/3/discover/movie?api_key=6e0422a0b1baeeb1f3b87024ff898eb8&region=RU&language=ru&sort_by=popularity.desc"
        val request = Request.Builder()
            .url(url)
            .build()
        val httpClient = OkHttpClient()
        httpClient.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, PosterFeed::class.java)
                runOnUiThread {
                    posterRecycler.adapter = PosterAdapter(homeFeed)}
            }
            override fun onFailure(call: Call, e: IOException) {
            }
        })

    }

}

class PosterFeed(val results: List<PosterResults>){}

class PosterResults(val vote_count:Int, val id: Int, val video:Boolean, val vote_average:Double, val title: String, val popularity:Double,
              val poster_path:String, val original_language:String, val original_title:String,
              val backdrop_path:String, val adult:Boolean, val overview:String, val release_date:String )
