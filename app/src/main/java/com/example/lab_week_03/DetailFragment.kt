package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {
    private lateinit var nameText: TextView
    private lateinit var descriptionText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        nameText = view.findViewById(R.id.coffee_name_text)
        descriptionText = view.findViewById(R.id.coffee_description_text)

        val name = arguments?.getString("name")
        val description = arguments?.getString("description")

        if (!name.isNullOrEmpty() && !description.isNullOrEmpty()) {
            nameText.text = name
            descriptionText.text = description
        }

        return view
    }
}