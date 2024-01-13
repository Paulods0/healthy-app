package com.example.healthyapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.healthyapp.Activity.DetailActivity
import com.example.healthyapp.Domain.ItemsDomain
import com.example.healthyapp.R

class BestDealAdapter(itemsArr: ArrayList<ItemsDomain>) :
    RecyclerView.Adapter<BestDealAdapter.ViewHolder>() {

    val items: ArrayList<ItemsDomain> = itemsArr
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_best_deal, parent, false)
        return ViewHolder(inflate)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTxt.text = items[position].title
        holder.priceTxt.text = items[position].price.toString() + "$/kg"

        val drawableResourceId = holder.itemView.resources.getIdentifier(
            items[position].imgPath,
            "drawable",
            holder.itemView.context.packageName
        )

        Glide.with(context)
            .load(drawableResourceId)
            .into(holder.pic)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("object", items[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTxt: TextView = itemView.findViewById(R.id.bestDealTitleTxt)
        val priceTxt: TextView = itemView.findViewById(R.id.bestDealpriceTxt)
        val pic: ImageView = itemView.findViewById(R.id.bestDealViewHolderImg)
    }

}