package com.example.filmapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_page2.*
import kotlinx.android.synthetic.main.activity_page3.*
import kotlinx.coroutines.*
import okhttp3.*
import java.io.IOException
import kotlin.coroutines.CoroutineContext

class Page3 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)
        main_Recycler.layoutManager = LinearLayoutManager(this)
        fetchJson()
    }
    fun openPage(view: View)
    {
        val changePage = Intent(this, MainActivity::class.java)
        startActivity(changePage)
    }

    fun fetchJson()
    {
        val url = "https://api.themoviedb.org/3/discover/movie?api_key=6e0422a0b1baeeb1f3b87024ff898eb8&primary_release_date.lte=2019-04-25"
        val request = Request.Builder().url(url).build()
        val httpClient = OkHttpClient()
        httpClient.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)
                runOnUiThread {
                    main_Recycler.adapter = SecondAdapter(homeFeed) }
            }
            override fun onFailure(call: Call, e: IOException) {
            }
        })

    }
}

class HomeFeed(val results: List<Results>)

class Results(val vote_count:Int, val id: Int, val video:Boolean, val vote_average:Float, val title: String, val popularuty:Float,
              val poster_path:String, val original_language:String, val original_title:String, val genre_ids:Genre_ids,
              val backdrop_path:String, val adult:Boolean, val overview:String, val release_date:String )

class Genre_ids(@SerializedName("0") val smth1:Int, @SerializedName("1") val smth2:Int, @SerializedName("2") val smth3:Int )
