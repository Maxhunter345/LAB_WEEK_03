package com.example.lab_week_03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(), CoffeeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, ListFragment())
            }
        }
    }

    override fun onCoffeeSelected(index: Int) {
        val bundle = Bundle().apply { putInt(ListFragment.COFFEE_INDEX, index) }
        val detail = DetailFragment().apply { arguments = bundle }

        supportFragmentManager.commit {
            replace(R.id.fragment_container, detail)
            addToBackStack(null)
        }
    }
}
