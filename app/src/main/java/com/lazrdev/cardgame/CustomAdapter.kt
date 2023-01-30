package com.lazrdev.cardgame

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var context: Context, private var item: List<Item>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rowlayout, parent, false)
        return MyViewHolder(v)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // set the data in items
        //holder.title.text = item[position].title
        holder.slika.setImageDrawable(item[position].slika)

        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener { // display a toast with person name on item click
           // Toast.makeText(context, item[position], Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
        return item.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var title: TextView = itemView.findViewById<View>(R.id.tvName) as TextView
        var slika: ImageView = itemView.findViewById<View>(R.id.img) as ImageView
    }
}
