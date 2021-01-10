package com.example.instagram.adpters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.models.ImageClass
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card.view.*
import kotlinx.android.synthetic.main.item_view_rv.view.*

class RvAdapter(var list: ArrayList<ImageClass>):RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(itemView:View):RecyclerView.ViewHolder(itemView){
        fun onBind(image: ImageClass){
           itemView.image.setImageResource(image.imgUrl!!)
            itemView.title.text = image.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
      return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_view_rv,parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }
}