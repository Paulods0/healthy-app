package com.example.healthyapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.healthyapp.Domain.ItemsDomain
import com.example.healthyapp.R

class SimilarAdapter (items : ArrayList<ItemsDomain>) : RecyclerView.Adapter<SimilarAdapter.ViewHolder>() {
    val items = items
    lateinit var context : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_similar, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val drawableResourceId = holder.itemView.resources
            .getIdentifier(items[position].imgPath, "drawable", holder.itemView.context.packageName)

        Glide.with(context)
            .load(drawableResourceId)
            .into(holder.pic)
    }

    class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        var pic: ImageView
        init {
            pic = itemView.findViewById(R.id.similarViewImg)
        }
    }
}