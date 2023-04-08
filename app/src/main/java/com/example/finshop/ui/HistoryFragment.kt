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
import com.example.finshop.adapters.HistoryAdapter
import com.example.finshop.models.History

class HistoryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var historyAdapter: HistoryAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.history_fragment, container, false)
        recyclerView = view.findViewById(R.id.rvHistory)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        historyAdapter = HistoryAdapter()
        recyclerView.adapter = historyAdapter
        val historyList = createDummyHistoryList()
        historyAdapter.submitList(historyList)
        return view
    }

    @SuppressLint("SuspiciousIndentation")
    private fun createDummyHistoryList(): MutableList<History> {
        val historyList = mutableListOf<History>()
        historyList.add(History("Product 1", 10.99, 2,20.99,"11/01/2023","09:27"))
        historyList.add(History("Product 2", 120.99,2,240.99,"21/11/2022","19:31"))
        historyList.add(History("Product 3", 210.99, 4,840.99,"1/04/2022","11:27"))
        historyList.add(History("Product 4", 310.99, 3,930.99,"15/08/2021","14:57"))
        historyList.add(History("Product 5", 410.99, 2,20.99,"11/01/2023","09:27"))
        historyList.add(History("Product 6", 510.99, 2,20.99,"11/01/2023","09:27"))
        historyList.add(History("Product 3", 210.99, 4,840.99,"1/04/2022","11:27"))
        historyList.add(History("Product 4", 310.99, 3,930.99,"15/08/2021","14:57"))
        historyList.add(History("Product 5", 410.99, 2,20.99,"11/01/2023","09:27"))
        historyList.add(History("Product 6", 510.99, 2,20.99,"11/01/2023","09:27"))
        return historyList
    }
}

