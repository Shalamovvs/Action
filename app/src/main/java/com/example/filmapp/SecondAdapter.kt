package com.example.filmapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_base.view.*

class SecondAdapter(val homeFeed:HomeFeed): RecyclerView.Adapter<CustomViewHolderBase>(){

    override fun getItemCount(): Int {
        return homeFeed.results.count()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolderBase {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_base, p0, false)
        return CustomViewHolderBase(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolderBase, position: Int) {
        val film = homeFeed.results.get(position)
        holder.view.movie_view_title.text = film.title
        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2"+film.poster_path).into(holder.view.posterView);
        holder.view.overviewView.text = film.overview
    }
}
class CustomViewHolderBase(val view:View): RecyclerView.ViewHolder(view){

}