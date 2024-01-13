package com.example.healthyapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.healthyapp.Adapter.BestDealAdapter
import com.example.healthyapp.Adapter.CategoryAdapter
import com.example.healthyapp.Domain.CategoryDomain
import com.example.healthyapp.Domain.ItemsDomain
import com.example.healthyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var catAdapter: RecyclerView.Adapter<*>
    private lateinit var bestDealAdapter: RecyclerView.Adapter<*>

    private lateinit var recyclerViewCat: RecyclerView
    private lateinit var recyclerViewBestDeal: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerViewCat()
        initLocation()
        initRecyclerViewBestDeal()
    }

    private fun initRecyclerViewCat() {
        val items: ArrayList<CategoryDomain> = ArrayList<CategoryDomain>()
        items.add(CategoryDomain("cat1", "Vegetable"))
        items.add(CategoryDomain("cat2", "Fruits"))
        items.add(CategoryDomain("cat3", "Dairy"))
        items.add(CategoryDomain("cat4", "Drinks"))
        items.add(CategoryDomain("cat5", "Grain"))

        binding.catView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        catAdapter = CategoryAdapter(items, this)
        binding.catView.adapter = catAdapter
    }

    private fun initLocation() {
        val items = arrayOf("Luanda, AO", "Benguela, AO", "Huambo, AO")
        val locationSpin: Spinner = binding.spinner
        val adapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        locationSpin.adapter = adapter
    }

    private fun initRecyclerViewBestDeal() {
        binding.bestView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        bestDealAdapter = BestDealAdapter(getData())
        binding.bestView.adapter = bestDealAdapter
    }

    fun getData(): ArrayList<ItemsDomain> {
        val items: ArrayList<ItemsDomain> = ArrayList()
        items.add(
            ItemsDomain(
                "orange",
                "Fresh Orange",
                6.99,
                "With its vibrating orange hue and a burst of refreshing" +
                        "citrus flavor, the juicy orange is a natural source of" +
                        "vitamin C, invigorating your senses and" +
                        "supporting your immune system. A delightful snack" +
                        "that combines health and taste.",
                4
            )
        )
        items.add(
            ItemsDomain(
                "apple",
                "Fresh apple",
                6.99,
                "Crisp and succulent, apples are nature's candy. Each bite offers a symphony of sweetness and a satisfying crunch. Packed with fiber and antioxidants, apples make for a wholesome snack, keeping you energized throughout the day.",
                4
            )
        )
        items.add(
            ItemsDomain(
                "watermelon",
                "Fresh watermelon",
                5.99,
                "Quench your thirst and satisfy your sweet tooth with the hydrating goodness of watermelon Bursting with juiciness and vibrating color, this summer favorite is a natural way to stay cool and refreshed. Enjoy the taste of summer with every juicy bites.",
                5
            )
        )
        items.add(
            ItemsDomain(
                "berry",
                "Fresh berry",
                5.12,
                "Nature's little jewels, cherries are a burst of sweet indulgence. Packed with antioxidants, these tiny treats not only satisfy your sweet cravings but also contribute to overall well-being. Pop a handful for a guilt-free snack that delights your taste buds.",
                4
            )
        )
        items.add(
            ItemsDomain(
                "pineaplle",
                "Fresh pineapple",
                10.99,
                "Transport yourself to the tropics with the exotic taste of pineapple. Juicy and tantalizingly sweet, this golden fruit is not only a treat for your taste buds  but also a rich source of vitamins and enzymes, promoting digestive health and adding a splash of sunshine to your day.",
                3
            )
        )
        items.add(
            ItemsDomain(
                "strawberry",
                "Fresh strawberry",
                12.0,
                "Delight in the sweetness of strawberries, each berry is a burst of flavor and nutrition. Whether enjoyed on their own or added to your favorite dishes, these red gems are a guilt-free pleasure, offering a dose of vitamin C, antioxidants and a touch of natural sweetness.",
                4
            )
        )
        return items
    }
}



