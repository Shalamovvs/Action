package com.example.filmapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.Gson
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_page2.*
import kotlinx.android.synthetic.main.activity_page3.*
import kotlinx.coroutines.*
import okhttp3.*
import java.io.IOException
import java.util.*
import kotlin.coroutines.CoroutineContext

class Page3 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)
        main_Recycler.layoutManager = LinearLayoutManager(this)
        fetchJson()
        val itemDecoration = DividerItemDecoration(applicationContext,1)
        itemDecoration.setDrawable(ColorDrawable(Color.BLACK))
        main_Recycler.addItemDecoration(itemDecoration)
    }
    fun openPage(view: View)
    {
        val changePage = Intent(this, MainActivity::class.java)
        startActivity(changePage)
    }

    fun fetchJson()
    {
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val dateText = dateFormat.format(currentDate)
        val url = "https://api.themoviedb.org/3/discover/movie?api_key=6e0422a0b1baeeb1f3b87024ff898eb8&region=RU&language=ru&release_date.gte="+dateText+"&with_release_type=2|3"
        val request = Request.Builder()
            .url(url)
            .build()
        val httpClient = OkHttpClient()
        httpClient.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)
                runOnUiThread {
                    main_Recycler.adapter = SecondAdapter(homeFeed)}
            }
            override fun onFailure(call: Call, e: IOException) {
            }
        })

    }
}

class HomeFeed(val results: List<Results>){}

class Results(val vote_count:Int, val id: Int, val video:Boolean, val vote_average:Double, val title: String, val popularity:Double,
              val poster_path:String, val original_language:String, val original_title:String, /*@SerializedName("genre_ids") val genre_ids:Genre_ids,*/
              val backdrop_path:String, val adult:Boolean, val overview:String, val release_date:String )

