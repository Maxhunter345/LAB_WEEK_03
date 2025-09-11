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
import androidx.navigation.Navigation

class ListFragment : Fragment() {

    private var listener: CoffeeListener? = null

    interface CoffeeListener {
        fun onCoffeeSelected(name: String, description: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView = view.findViewById<ListView>(R.id.coffee_list_view)
        val coffeeNames = resources.getStringArray(R.array.coffee_names)
        val coffeeDescriptions = resources.getStringArray(R.array.coffee_descriptions)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, coffeeNames)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val name = coffeeNames[position]
            val description = coffeeDescriptions[position]

            val detailContainerPresent = requireActivity().findViewById<View?>(R.id.detail_fragment) != null

            if (detailContainerPresent && listener != null) {
                listener!!.onCoffeeSelected(name, description)
            } else {
                val bundle = Bundle().apply {
                    putString("name", name)
                    putString("description", description)
                }
                Navigation.findNavController(view).navigate(
                    R.id.action_listFragment_to_detailFragment,
                    bundle
                )
            }
        }
    }
}