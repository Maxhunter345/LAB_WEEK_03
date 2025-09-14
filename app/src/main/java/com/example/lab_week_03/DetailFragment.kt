package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeId = arguments?.getInt(ListFragment.COFFEE_INDEX)

        val coffeeName = when (coffeeId) {
            0 -> "Affogato"
            1 -> "Americano"
            2 -> "Latte"
            3 -> "Cappuccino"
            4 -> "Mocha"
            else -> "Unknown Coffee"
        }

        val coffeeDesc = when (coffeeId) {
            0 -> "Espresso poured over vanilla ice cream"
            1 -> "Espresso with added hot water"
            2 -> "Espresso with steamed milk and foam"
            3 -> "Equal parts espresso, steamed milk, and foam"
            4 -> "Espresso mixed with chocolate and steamed milk"
            else -> "No description avaiable"
        }

        view.findViewById<TextView>(R.id.coffee_name_text).text = coffeeName
        view.findViewById<TextView>(R.id.coffee_description_text).text = coffeeDesc

        view.findViewById<Button>(R.id.back_button).setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}