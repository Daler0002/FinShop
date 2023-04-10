package com.example.finshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.finshop.databinding.ItemProductBinding
import com.example.finshop.models.History
import com.example.finshop.models.Product

class ProductAdapter : ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
    inner class ProductViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        private val itemAmount: EditText = binding.itemAmountProd
        private val itemPlusBtn: Button = binding.btnPlus
        private val itemMinusBtn: Button = binding.btnMinus

        fun bind(product: Product) {
            binding.itemName.text = product.name
            binding.itemPrice.text = product.price.toString()
            binding.itemImage.setImageResource(product.image.toInt())

        itemPlusBtn.setOnClickListener {
            val text = itemAmount.text.toString()
            val value = text.toIntOrNull() ?: 0
            val incrementedValue = value + 1
            itemAmount.setText(incrementedValue.toString())
        }

        itemMinusBtn.setOnClickListener {
            val text = itemAmount.text.toString()
            val value = text.toIntOrNull() ?: 0
            val decrementedValue = value - 1
            itemAmount.setText(decrementedValue.toString())
            }
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
