package com.example.finshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.finshop.databinding.ItemHistoryBinding
import com.example.finshop.models.History

class HistoryAdapter : ListAdapter<History, HistoryAdapter.HistoryViewHolder>(HistoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryBinding.inflate(inflater, parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: History) {
            binding.itemName.text = product.name
            binding.itemPrice.text = product.price.toString()
            binding.itemCount.text = product.count.toString()
            binding.itemSumm.text = product.sum.toString()
            binding.itemDate.text = product.data.toString()
            binding.itemTime.text = product.time.toString()
        }
    }

    class HistoryDiffCallback : DiffUtil.ItemCallback<History>() {

        override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
            return oldItem.name == newItem.name && oldItem.price == newItem.price && oldItem.count == newItem.count && oldItem.sum == newItem.sum  && oldItem.data == newItem.data && oldItem.time == newItem.time
        }
    }
}
