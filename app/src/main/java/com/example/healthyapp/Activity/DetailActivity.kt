package com.example.healthyapp.Activity

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.healthyapp.Domain.ItemsDomain
import com.example.healthyapp.databinding.ActivityDetailBinding
import java.io.Serializable

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
    }

    private fun setVariable() {
        backBtn.setOnClickListener {
            finish()
        }

        val drawableResourceId = resources.getIdentifier(obj.imgPath, "drawable", this.packageName)
        Glide.with(this)
            .load(drawableResourceId)
            .into(itemImg)

        priceKgTxt.text = obj.price.toString()
        titleTxt.text = obj.title
        description.text = obj.description
        ratingTxt.text = "(" + obj.rate + ")"
        ratingBar.rating = obj.rate as Float

        plusBtn.setOnClickListener {
            weight += 1
            weightTxt.text = weight.toString() + " kg"
            val res = weight * obj.price
            totalTxt.text = res.toString()
        }

        minusBtn.setOnClickListener {
            if (weight > 1) {
                weight -= 1
                weightTxt.text = weight.toString() + " kg"
                val res = weight * obj.price
                totalTxt.text = res.toString()
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


    fun <T : Serializable?> getSerializable(activity: Activity, name: String, clazz: Class<T>): T {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            activity.intent.getSerializableExtra(name, clazz)!!
        else {
            activity.intent.getSerializableExtra(name) as T
        }
    }

    private fun getBundles() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            obj = intent.getSerializableExtra("object", ItemsDomain::class.java)
                ?: throw IllegalArgumentException("Object cannot be null")
        }
    }
}