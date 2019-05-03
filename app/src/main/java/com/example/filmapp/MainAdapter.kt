package com.example.filmapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.movie_list.view.*

class MainAdapter(val nameList:ArrayList<Model>):RecyclerView.Adapter<CustomViewHolder>(){

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_list, p0, false)
        return CustomViewHolder(cellForRow)

    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.film_view_title.text = nameList[position].name
        holder.view.film_view_year.text = nameList[position].year
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}