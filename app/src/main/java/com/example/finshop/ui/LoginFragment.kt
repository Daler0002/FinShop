package com.example.finshop.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.finshop.R

class LoginFragment : Fragment() {

    @SuppressLint("MissingInflatedId", "InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, null, false)
        view.findViewById<Button>(R.id.button)?.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_loginFragment_to_categoriesFragment)
        }
        return view
    }
}