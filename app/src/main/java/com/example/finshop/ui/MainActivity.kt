package com.example.finshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.finshop.R
import com.example.finshop.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        replaceFragment(CategoriesFragment())

        bottomNavBar()
      }
    private fun bottomNavBar() {
        binding.bottomNavigationBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(CategoriesFragment())
                    true
                }
                R.id.story -> {
                    replaceFragment(HistoryFragment())
                    true
                }
                R.id.news -> {
                    replaceFragment(NewsFragment())
                    true
                }
                R.id.shop -> {
                    replaceFragment(ShopFragment())
                    true
            }
                R.id.account -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
      }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment)
        fragmentTransaction.commit()
    }
    }