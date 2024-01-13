package com.example.healthyapp.Activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.healthyapp.Adapter.SimilarAdapter
import com.example.healthyapp.Domain.ItemsDomain
import com.example.healthyapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var obj: ItemsDomain
    private lateinit var backBtn: ImageView
    private lateinit var itemImg: ImageView
    private lateinit var priceKgTxt: TextView
    private lateinit var titleTxt: TextView
    private lateinit var description: TextView
    private lateinit var ratingTxt: TextView
    private lateinit var weightTxt: TextView
    private lateinit var plusBtn: TextView
    private lateinit var minusBtn: TextView
    private lateinit var totalTxt: TextView
    private lateinit var ratingBar: RatingBar

    private lateinit var similarAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerViewSimilar: RecyclerView

    private var weight = 1

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundles()
        initView()
        setVariable()
        initSimilar()
    }

    private fun initSimilar() {
        recyclerViewSimilar = binding.similarView
        recyclerViewSimilar.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        similarAdapter = SimilarAdapter(MainActivity().getData())
        recyclerViewSimilar.adapter = similarAdapter
    }

    private fun setVariable() {
        backBtn.setOnClickListener {
            finish()
        }

        val drawableResourceId = resources.getIdentifier(obj.imgPath, "drawable", this.packageName)
        Glide.with(this)
            .load(drawableResourceId)
            .into(itemImg)

        priceKgTxt.text = "${obj.price}$/kg"
        titleTxt.text = obj.title
        description.text = obj.description
        ratingTxt.text = "(${obj.rate})"
        ratingBar.rating = obj.rate.toFloat()
        totalTxt.text = "$${(weight * obj.price)}"
        plusBtn.setOnClickListener {
            weight += 1
            weightTxt.text = "$weight kg"
            val res = weight * obj.price
            totalTxt.text = "$${res}"
        }

        minusBtn.setOnClickListener {
            if (weight > 1) {
                weight -= 1
                weightTxt.text = "$weight kg"
                val res = weight * obj.price
                totalTxt.text = "$${res}"
            }
        }
    }

    private fun initView() {
        backBtn = binding.backBtn
        itemImg = binding.detailCatImg
        priceKgTxt = binding.priceKgTxt
        titleTxt = binding.titleTxt
        description = binding.descriptionTxt
        ratingBar = binding.ratingBar
        ratingTxt = binding.ratingTxt
        weightTxt = binding.weigthBtn
        plusBtn = binding.plusBtn
        minusBtn = binding.minusBtn
        totalTxt = binding.totalTxt
    }

    private fun getBundles() {
        obj = intent.extras?.getSerializable("object", ItemsDomain::class.java)!!
    }

}