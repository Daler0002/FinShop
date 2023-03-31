package com.example.finshop.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finshop.models.Product

class ProductViewModel : ViewModel() {
    private val _products = MutableLiveData<MutableList<Product>>()
    val products: LiveData<MutableList<Product>>
        get() = _products

    init {
        _products.value = mutableListOf()
    }

    fun addProduct(product: Product) {
        _products.value?.add(product)
        _products.value = _products.value
    }
}
