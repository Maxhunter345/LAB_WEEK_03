package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.util.Log

class ListFragment : Fragment() {
    private var listener: CoffeeListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is CoffeeListener) context else throw RuntimeException("$context must implement CoffeeListener")
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ids = listOf(
            R.id.affogato,
            R.id.americano,
            R.id.latte,
            R.id.cappuccino,
            R.id.mocha
        )

        for ((index, id) in ids.withIndex()) {
            val itemView = view.findViewById<View>(id)
            itemView?.setOnClickListener {
                Log.d("ListFragment", "clicked index=$index id=$id")
                listener?.onCoffeeSelected(index)
            }
        }
    }

    companion object {
        const val COFFEE_INDEX = "COFFEE_INDEX"
    }
}