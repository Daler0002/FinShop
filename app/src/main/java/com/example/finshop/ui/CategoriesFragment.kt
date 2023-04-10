package com.example.finshop.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finshop.R
import com.example.finshop.adapters.ProductAdapter
import com.example.finshop.models.Product

class CategoriesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.categories_fragment, container, false)
        recyclerView = view.findViewById(R.id.rvCategories)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        productAdapter = ProductAdapter()
        recyclerView.adapter = productAdapter
        val productList = createDummyProductList()
        productAdapter.submitList(productList)
        return view
    }

    @SuppressLint("SuspiciousIndentation")
    private fun createDummyProductList(): MutableList<Product> {
        val productList = mutableListOf<Product>()
            productList.add(Product("Product 1", 10.99, R.drawable.item_image))
            productList.add(Product("Product 2", 120.99, R.drawable.item_image))
            productList.add(Product("Product 3", 210.99, R.drawable.item_image))
            productList.add(Product("Product 4", 310.99, R.drawable.item_image))
            productList.add(Product("Product 5", 410.99, R.drawable.item_image))
            productList.add(Product("Product 6", 510.99, R.drawable.item_image))
        return productList
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val itemAmount = view?.findViewById<EditText>(R.id.item_amount_prod)
        val itemPlusBtn = view?.findViewById<Button>(R.id.btn_plus)
        val itemMinusBtn = view?.findViewById<Button>(R.id.btn_minus)

        itemPlusBtn?.setOnClickListener {
            val text = itemAmount?.text.toString()
            val value = text.toIntOrNull() ?: 0
            val incrementedValue = value + 1
            itemAmount?.setText(incrementedValue.toString())
        }

        itemMinusBtn?.setOnClickListener {
            val text = itemAmount?.text.toString()
            val value = text.toIntOrNull() ?: 0
            val decrementedValue = value - 1
            itemAmount?.setText(decrementedValue.toString())
        }
    }
}
