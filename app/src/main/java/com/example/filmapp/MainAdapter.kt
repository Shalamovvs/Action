package com.example.filmapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.movie_list.view.*

class MainAdapter:RecyclerView.Adapter<CustomViewHolder>(){

    val filmTitles = listOf("First title", "Second title")
    //numberOfItems
    override fun getItemCount(): Int {
        return filmTitles.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_list, p0, false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        val filmTitle = filmTitles.get(p1)
        p0.itemView.film_view_title.text = filmTitle
    }

    /*override fun onBindViewHolder(holder: CustomViewHolder, position: Int, payloads: MutableList<Any>) {
        val filmTitle = filmTitles.get(position)
        holder.itemView.film_view_title.text = filmTitle
    }*/

}

class CustomViewHolder(v: View): RecyclerView.ViewHolder(v){

}