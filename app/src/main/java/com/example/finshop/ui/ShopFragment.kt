package com.example.finshop.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finshop.R
import com.example.finshop.adapters.ProductAdapter
import com.example.finshop.adapters.ShopAdapter
import com.example.finshop.models.Product

class ShopFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var shopAdapter: ShopAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shop, container, false)
        recyclerView = view.findViewById(R.id.rvShop)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        shopAdapter = ShopAdapter()
        recyclerView.adapter = shopAdapter
        val productList = createDummyProductList()
        shopAdapter.submitList(productList)
        return view
    }

    @SuppressLint("SuspiciousIndentation")
    private fun createDummyProductList(): MutableList<Product>? {
        val productList = mutableListOf<Product>()
        productList.add(Product("Product 1", 10.99, R.drawable.item_image))
        productList.add(Product("Product 2", 120.99, R.drawable.item_image))
        productList.add(Product("Product 3", 210.99, R.drawable.item_image))
        productList.add(Product("Product 4", 310.99, R.drawable.item_image))
        productList.add(Product("Product 5", 410.99, R.drawable.item_image))
        productList.add(Product("Product 6", 510.99, R.drawable.item_image))
        return productList
    }
}
