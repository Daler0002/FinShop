package com.example.finshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.finshop.adapters.ProductAdapter
import com.example.finshop.databinding.ActivityMainBinding
import com.example.finshop.viewModels.ProductViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter
    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        adapter = ProductAdapter()
        viewModel.products.observe(this) { products ->
            adapter.submitList(products)
        }
      }
    }