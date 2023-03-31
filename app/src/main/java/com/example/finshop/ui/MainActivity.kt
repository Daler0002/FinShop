package com.example.finshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.finshop.databinding.ActivityMainBinding
import com.example.finshop.models.Product
import com.example.finshop.viewModels.ProductViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        val adapter = ProductAdapter(productViewModel.getProductList())
        binding.recyclerView.adapter = adapter

        binding.addButton.setOnClickListener {
            val name = binding.itemName.text.toString()
            val price = binding.priceEditText.text.toString().toDoubleOrNull()

            if (name.isNotEmpty() && price != null) {
                val product = Product(name, price)
                productViewModel.addProduct(product)
                adapter.notifyDataSetChanged()
            }

            binding.nameEditText.text.clear()
            binding.priceEditText.text.clear()
        }
    }
//     override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
}