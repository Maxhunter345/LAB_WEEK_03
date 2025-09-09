package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private lateinit var listener: CoffeeListener

    interface CoffeeListener {
        fun onCoffeeSelected(name: String, description: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement CoffeeListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val listView = view.findViewById<ListView>(R.id.coffee_list_view)
        val coffeeNames = resources.getStringArray(R.array.coffee_names)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, coffeeNames)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val names = resources.getStringArray(R.array.coffee_names)
            val descriptions = resources.getStringArray(R.array.coffee_descriptions)
            listener.onCoffeeSelected(names[position], descriptions[position])
        }

        return view
    }
}