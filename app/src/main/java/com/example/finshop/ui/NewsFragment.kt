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
import com.example.finshop.adapters.NewsAdapter
import com.example.finshop.models.News

class NewsFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_fragment, container, false)
        recyclerView = view.findViewById(R.id.rvNews)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        newsAdapter = NewsAdapter()
        recyclerView.adapter = newsAdapter
        val newsList = createDummyProductList()
        newsAdapter.submitList(newsList)
        return view
    }

    private fun createDummyProductList(): MutableList<News>? {
        val newsList = mutableListOf<News>()
        newsList.add(News("Добавлен новый товар", "Air Max 2021",444, R.drawable.cross))
        newsList.add(News("Добавлен новый товар", "Air Max 2022", 544, R.drawable.cross))
        newsList.add(News("Добавлен новый товар", "Air Max 2023", 644,R.drawable.cross))
        return newsList
    }
}