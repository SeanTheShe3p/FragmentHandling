package com.example.fragmenthandling.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragmenthandling.R

class Fragment_Receive : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment__receive, container, false)

        val recvtext = arguments?.getString("AtoB")
        val printtxt = view.findViewById<TextView>(R.id.recvText)
        printtxt.setText(recvtext)


        return view
    }

}