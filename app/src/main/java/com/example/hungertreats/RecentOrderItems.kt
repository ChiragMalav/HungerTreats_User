package com.example.hungertreats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hungertreats.Adapter.RecentBuyAdapter
import com.example.hungertreats.databinding.ActivityRecentOrderItemsBinding
import com.example.hungertreats.model.OrderDetails

class RecentOrderItems : AppCompatActivity() {
    private lateinit var binding: ActivityRecentOrderItemsBinding
    private lateinit var allFoodNames: ArrayList<String>
    private lateinit var allFoodImages: ArrayList<String>
    private lateinit var allFoodPrices: ArrayList<String>
    private lateinit var allFoodQuantities: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecentOrderItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("RecentOrderItems", "onCreate called")
        val recentOrderItems = intent.getSerializableExtra("RecentBuyOrderItem") as? ArrayList<OrderDetails>
        Log.d("RecentOrderItems", "Received data: $recentOrderItems")

        if (recentOrderItems != null && recentOrderItems.isNotEmpty()) {
            val recentOrderItem = recentOrderItems[0]
            Log.d("RecentOrderItems", "Processing first item: $recentOrderItem")

            allFoodNames = recentOrderItem.foodNames as? ArrayList<String> ?: arrayListOf()
            allFoodImages = recentOrderItem.foodImages as? ArrayList<String> ?: arrayListOf()
            allFoodPrices = recentOrderItem.foodPrices as? ArrayList<String> ?: arrayListOf()
            allFoodQuantities = recentOrderItem.foodQuantities as? ArrayList<Int> ?: arrayListOf()
        } else {
            Log.d("RecentOrderItems", "OrderDetails list is empty or null")
            allFoodNames = arrayListOf()
            allFoodImages = arrayListOf()
            allFoodPrices = arrayListOf()
            allFoodQuantities = arrayListOf()

            // Use sample data for testing
            // Uncomment the following lines to use sample data
            allFoodNames = arrayListOf("Pizza", "Burger", "Pasta")
            allFoodImages = arrayListOf(
                 "https://example.com/pizza.jpg",
                 "https://example.com/burger.jpg",
                 "https://example.com/pasta.jpg"
             )
             allFoodPrices = arrayListOf("$10", "$8", "$12")
             allFoodQuantities = arrayListOf(1, 2, 1)
        }

        // Log the lists to verify data population
        Log.d("RecentOrderItems", "allFoodNames: $allFoodNames")
        Log.d("RecentOrderItems", "allFoodImages: $allFoodImages")
        Log.d("RecentOrderItems", "allFoodPrices: $allFoodPrices")
        Log.d("RecentOrderItems", "allFoodQuantities: $allFoodQuantities")

        setAdapter()
    }

    private fun setAdapter() {
        val rv = binding.recyclerViewRecentBuy
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = RecentBuyAdapter(this, allFoodNames, allFoodImages, allFoodPrices, allFoodQuantities)
        rv.adapter = adapter
    }
}
