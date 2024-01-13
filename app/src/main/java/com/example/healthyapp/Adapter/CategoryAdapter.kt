package com.example.healthyapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.healthyapp.Domain.CategoryDomain
import com.example.healthyapp.R
import com.example.healthyapp.databinding.ViewholderCategoryBinding

class CategoryAdapter(private val items: ArrayList<CategoryDomain>, private val context: Context) : RecyclerView.Adapter<CategoryAdapter.Viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val category = items[position]
        holder.titleTxt.text = category.title
        val resourceId = context.resources.getIdentifier(category.imgPath, "drawable", context.packageName)

        Glide.with(context)
            .load(resourceId)
            .into(holder.pic)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Viewholder(private val binding: ViewholderCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        var titleTxt: TextView = binding.titleTxt
        var pic: ImageView = binding.catViewHolderImg
    }
}