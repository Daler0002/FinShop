package com.example.finshop.repository

import com.example.finshop.models.Product

class ProductRepository {
    private val productList = mutableListOf<Product>()

    fun addProduct(product: Product) {
        productList.add(product)
    }

    fun getProductList(): List<Product> {
        return productList
    }
}