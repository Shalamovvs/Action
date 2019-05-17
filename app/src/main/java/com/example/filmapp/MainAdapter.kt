package com.example.filmapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.movie_list.view.*
import android.text.method.TextKeyListener.clear
import android.text.method.TextKeyListener.clear





class MainAdapter(val nameList:ArrayList<String>):RecyclerView.Adapter<CustomViewHolder>(){
    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_list, p0, false)
        return CustomViewHolder(cellForRow)

    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val item = nameList.get(position)
        val splittedText = item.split("\n")
        holder.view.film_view_title.text = splittedText.get(0)
        holder.view.film_view_year.text = splittedText.get(1)
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}
