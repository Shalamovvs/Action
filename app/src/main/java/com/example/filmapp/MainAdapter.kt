package com.example.filmapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.movie_list.view.*

class MainAdapter(var numbers:Int):RecyclerView.Adapter<CustomViewHolder>(){

    override fun getItemCount(): Int {
        return numbers
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_list, p0, false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        //val filmTitle = filmTitles.get(p1)
        //p0.itemView.film_view_title.text = filmTitle
    }


}

class CustomViewHolder(v: View): RecyclerView.ViewHolder(v){

}