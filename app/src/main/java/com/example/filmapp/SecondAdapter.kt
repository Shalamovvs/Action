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
        holder.view.movie_view_title.text = film.original_title
        holder.view.movie_view_year.text = film.release_date
    }
}
class CustomViewHolderBase(val view:View): RecyclerView.ViewHolder(view){

}