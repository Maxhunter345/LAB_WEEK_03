package com.example.lab_week_03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ListFragment.CoffeeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCoffeeSelected(name: String, description: String) {
        val detailFragment =
            supportFragmentManager.findFragmentById(R.id.detail_fragment) as DetailFragment
        detailFragment.updateCoffee(name, description)
    }
}