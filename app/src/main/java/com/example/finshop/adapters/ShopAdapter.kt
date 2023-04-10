package com.example.finshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.finshop.databinding.ItemProductBinding
import com.example.finshop.databinding.ItemShopBinding
import com.example.finshop.models.Product

class ShopAdapter : ListAdapter<Product, ShopAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemShopBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class ProductViewHolder(private val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.itemName2.text = product.name
            binding.itemPrice2.text = product.price.toString()
            binding.itemImage2.setImageResource(product.image.toInt())
        }
    }

    class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {

        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.name == newItem.name && oldItem.price == newItem.price && oldItem.image == newItem.image
        }
    }
}
