package com.example.instagram.adpters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.models.NewsClass
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.*

class RvAdapterEnd(var list: ArrayList<NewsClass>,var myItemClickListener: MyItemClickListener):RecyclerView.Adapter<RvAdapterEnd.Vh>() {
    inner class Vh(itemView:View):RecyclerView.ViewHolder(itemView){
        fun onBind(newsClass: NewsClass,position: Int){
            Picasso.get().load(newsClass.imgURL).into(itemView.image_pdp)
            itemView.setOnClickListener {
                myItemClickListener.OnItemClick(position,newsClass)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
     return Vh(LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
     holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int {
       return list.size
    }
    interface MyItemClickListener{
        fun OnItemClick(position: Int,newsClass: NewsClass)
    }
}